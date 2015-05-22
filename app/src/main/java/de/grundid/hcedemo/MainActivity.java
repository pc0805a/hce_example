package de.grundid.hcedemo;

import android.app.Activity;
import android.database.Cursor;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private NfcAdapter nfcAdapter;
	private ListView listView;
	private IsoDepAdapter isoDepAdapter;

	private Button confirm_btn;
	private TextView member_id_txt;

	private void initViews() {
		confirm_btn = (Button) findViewById(R.id.confirm_btn);
		member_id_txt = (TextView) findViewById(R.id.member_id);
	}

	private void setListeners() {
		confirm_btn.setOnClickListener(confirm);
	}

	private OnClickListener confirm = new OnClickListener(){
		@Override
		public void onClick(View v) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String currentDateandTime = sdf.format(new Date());

			String[] info = {member_id_txt.getText().toString(), currentDateandTime};

			Log.v(TAG, "Current Time: " + currentDateandTime);

			insertMemberInfo(info);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		setListeners();
		setAdapter();

	}



	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	private MemberInfo meberInfo;
	private Cursor mCursor;

	private void setAdapter() {
		meberInfo = new  MemberInfo(this);
		meberInfo.open();
	}

	private void insertMemberInfo(String[] data) {
		String[] insertData = new String[2];

		insertData[0] = data[0];//member id
		insertData[1] = data[1];//last update time


		meberInfo.delete(1);
		meberInfo.insert(insertData);
		getMemberInfo();

	}

	private void getMemberInfo() {
		Cursor cursor = meberInfo.getAll();
		int row_num = cursor.getCount();
		if (row_num != 0) {
			cursor.moveToFirst();
			Log.v(TAG, "ROWID: " + cursor.getLong(0));
			Log.v(TAG, "MID: " + cursor.getString(1));
			Log.v(TAG, "DateTime: " + cursor.getString(2));
//			currentCondition_txt.setText(cursor.getString(3));
//			humidity_txt.setText(cursor.getString(4));
//			currentTemperature_txt.setText(cursor.getString(5));
//			reliability_txt.setText(cursor.getDouble(6) + "%");
//			lastUpdate_txt.setText(cursor.getString(7));
		}
	}

}
