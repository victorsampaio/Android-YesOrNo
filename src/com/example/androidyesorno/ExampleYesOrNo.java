package com.example.androidyesorno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ExampleYesOrNo extends Activity implements OnClickListener {

	private static final int ACTIVITY_YES_NO = 1;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_example_yes_or_no);

		Button btScreen = (Button) findViewById(R.id.btnScreen);
		btScreen.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		startActivityForResult(new Intent(this, ScreenYesNo.class),
				ACTIVITY_YES_NO);

	}

	protected void onActivityResult(int code, int resultCode, Intent it) {
		if (code == ACTIVITY_YES_NO) {

			Bundle params = it != null ? it.getExtras(): null;
			
			if (params != null) {
				String msg = params.getString("msg");
				if (resultCode == 1) {
					// Yes
					Toast.makeText(this, "Selected Yes: " + msg,
							Toast.LENGTH_SHORT).show();
				} else if (resultCode == 2) {
					Toast.makeText(this, "Selected No: " + msg,
							Toast.LENGTH_SHORT).show();

				} else {
					Toast.makeText(this, "No Defined: " + msg,
							Toast.LENGTH_SHORT).show();
				}
			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.example_yes_or_no, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
