package com.logicmaster63.scouting;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

public class AndroidLauncher extends AndroidApplication implements AndroidStuff, GoogleApiHelper.ConnectionListener {

	private static final int RC_SIGN_IN = 9001;

	private FirebaseAuth mAuth;
	private GoogleApiHelper apiHelper;
	private User user;
	private FirebaseDatabase database;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mAuth = FirebaseAuth.getInstance();
		apiHelper = new GoogleApiHelper(getContext());
		apiHelper.setConnectionListener(this);

		database = FirebaseDatabase.getInstance();
		DatabaseReference online = database.getReferenceFromUrl("https://scouting2832.firebaseio.com/");
		online.child("event").child("midland").child("competition").child("test_email").child("can_climb").setValue(false);
		online.push();

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Scouting(this), config);
	}

	@Override
	public boolean isSignedIn() {
		return apiHelper.isConnected();
	}

	@Override
	public void signIn() {
		startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(apiHelper.getGoogleApiClient()), RC_SIGN_IN);
	}

	@Override
	public void signOut() {
		user = null;
		mAuth.signOut();
		Auth.GoogleSignInApi.revokeAccess(apiHelper.getGoogleApiClient());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RC_SIGN_IN) {
			GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
			if (result.isSuccess()) {
				GoogleSignInAccount account = result.getSignInAccount();
				AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
				mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
							@Override
							public void onComplete(@NonNull Task<AuthResult> task) {
								if (task.isSuccessful()) {
									FirebaseUser user = mAuth.getCurrentUser();
									AndroidLauncher.this.user = new User(user.getDisplayName(), user.getEmail());
									Gdx.app.error("GoogleAuth", user.getEmail());
								} else {
									Gdx.app.error("GoogleAuth", task.getException().toString());
								}
							}
						});
			} else {
				//Gdx.app.error("ActivityResult", result.getStatus().getStatusMessage());
			}
		}
	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
		if(Gdx.app != null)
			Gdx.app.error("ApiHelper", "Connection failed");
	}

	@Override
	public void onConnectionSuspended(int i) {
		Gdx.app.error("ApiHelper", "Connection Suspended");
	}

	@Override
	public void onConnected(Bundle bundle) {
		if(Gdx.app != null)
			Gdx.app.error("ApiHelper", "Connected");
	}

	@Override
	public User getUser() {
		return user;
	}
}
