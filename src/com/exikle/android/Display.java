package com.exikle.android;

import java.awt.Button;
import java.awt.Menu;
import java.util.Calendar;

import javax.swing.text.View;

public class Display extends Activity implements OnClickListener {

	Button btnCheck;

	EditText etDay, etMonth, etYear;

	TextView display;

	int day, month, year;

	Calendar c = Calendar.getInstance();

	int currentD = c.get(Calendar.DAY_OF_MONTH), currentM = c
			.get(Calendar.MONTH), currentY = c.get(Calendar.YEAR);

	int x = c.get(Calendar.DAY_OF_YEAR);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		btnCheck = (Button) findViewById(R.id.btnCheck);
		btnCheck.setOnClickListener(this);

		etDay = (EditText) findViewById(R.id.etDay);
		etMonth = (EditText) findViewById(R.id.etMonth);
		etYear = (EditText) findViewById(R.id.etYear);

		display = (TextView) findViewById(R.id.dayTillDisplay);
		// this.run();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.btnCheck) {
			String d = etDay.getText().toString(), m = etMonth
					.getText().toString(), y = etYear.getText()
					.toString();
			if ((d.equals("")) || (m.equals("")) || (y.equals(""))) {
				Toast toast = Toast.makeText(this, "Enter in Date",
						Toast.LENGTH_SHORT);
				toast.show();
			} else {
				day = Integer.parseInt(d);
				month = Integer.parseInt(m);
				year = Integer.parseInt(y);
			}
		}
	}

	public void updateCount(int days) {

		// display.setText(d + "/" + m + "/" + y);
		display.setText("There is " + days + " days left!");
	}
}
