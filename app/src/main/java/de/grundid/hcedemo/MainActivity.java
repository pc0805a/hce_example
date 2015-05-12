package de.grundid.hcedemo;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

	private NfcAdapter nfcAdapter;
	private ListView listView;
	private IsoDepAdapter isoDepAdapter;

	private Button confirm_btn;
	private TextView message_txt;

	private void initViews() {
		confirm_btn = (Button) findViewById(R.id.confirm_button);
		message_txt = (TextView) findViewById(R.id.message);
	}

	private void setListeners() {
		confirm_btn.setOnClickListener(confirm);
	}

	private OnClickListener confirm = new OnClickListener(){
		@Override
		public void onClick(View v) {

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}
