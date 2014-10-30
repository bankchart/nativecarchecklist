package com.example.nativecarchecklist;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private boolean[] menuIsShow;

	private final int POWER_INDEX = 0;
	private final int ENGINE_INDEX = 1;
	private final int EXTERIOR_INDEX = 2;
	private final int INTERIOR_INDEX = 3;
	private final int DOCUMENT_INDEX = 4;
	private final int SETTINT_INDEX = 5;

	public void checkSlide() {
		for (int i = 0; i < menuIsShow.length; i++) {
			if (menuIsShow[i]) {
				FragmentTransaction ft;
				switch (i) {
				case 0:
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					ft = getFragmentManager().beginTransaction()
							.setCustomAnimations(R.animator.power_motion_in,
									R.animator.power_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment powerFm = fm.findFragmentById(R.id.power_fm);
					ft.hide(powerFm);
					ft.commit();
					break;
				case 1:
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					ft = getFragmentManager().beginTransaction()
							.setCustomAnimations(R.animator.engine_motion_in,
									R.animator.engine_motion_out);
					fm = getFragmentManager();
					final Fragment engineFm = fm
							.findFragmentById(R.id.engine_fm);
					ft.hide(engineFm);
					ft.commit();
					break;
				case 2:
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					ft = getFragmentManager().beginTransaction()
							.setCustomAnimations(R.animator.exterior_motion_in,
									R.animator.exterior_motion_out);
					fm = getFragmentManager();
					final Fragment exteriorFm = fm
							.findFragmentById(R.id.exterior_fm);
					ft.hide(exteriorFm);
					ft.commit();
					break;
				case 3:
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					ft = getFragmentManager().beginTransaction()
							.setCustomAnimations(R.animator.interior_motion_in,
									R.animator.interior_motion_out);
					fm = getFragmentManager();
					final Fragment interiorFm = fm
							.findFragmentById(R.id.interior_fm);
					ft.hide(interiorFm);
					ft.commit();
					break;
				case 4:
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					ft = getFragmentManager().beginTransaction()
							.setCustomAnimations(R.animator.document_motion_in,
									R.animator.document_motion_out);
					fm = getFragmentManager();
					final Fragment documentFm = fm
							.findFragmentById(R.id.document_fm);
					ft.hide(documentFm);
					ft.commit();
					break;
				}
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final LinearLayout powerLayout = (LinearLayout) findViewById(R.id.power_layout);
		powerLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		final LinearLayout engineLayout = (LinearLayout) findViewById(R.id.engine_layout);
		engineLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		final LinearLayout exteriorLayout = (LinearLayout) findViewById(R.id.exterior_layout);
		exteriorLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		final LinearLayout interiorLayout = (LinearLayout) findViewById(R.id.interior_layout);
		interiorLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		final LinearLayout documentLayout = (LinearLayout) findViewById(R.id.document_layout);
		documentLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		menuIsShow = new boolean[] { false, // power
				false, // engine
				false, // exterior
				false, // interior
				false, // document
				false // setting
		};

		RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainlayout);

		mainLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				checkSlide();
			}

		});

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		FragmentManager fm = getFragmentManager();

		Fragment engineFm = fm.findFragmentById(R.id.engine_fm);
		Fragment engineSubFm = fm.findFragmentById(R.id.enginesub_fm);

		Fragment powerFm = fm.findFragmentById(R.id.power_fm);

		Fragment exteriorFm = fm.findFragmentById(R.id.exterior_fm);

		Fragment interiorFm = fm.findFragmentById(R.id.interior_fm);

		Fragment documentFm = fm.findFragmentById(R.id.document_fm);

		Button engineBackBtn = (Button) findViewById(R.id.engineBackBtn);
		Button powerBackBtn = (Button) findViewById(R.id.powerBackBtn);
		Button exteriorBackBtn = (Button) findViewById(R.id.exteriorBackBtn);
		Button interiorBackBtn = (Button) findViewById(R.id.interiorBackBtn);
		Button documentBackBtn = (Button) findViewById(R.id.documentBackBtn);

		ft.hide(engineFm);
		ft.hide(engineSubFm);
		ft.hide(powerFm);
		ft.hide(exteriorFm);
		ft.hide(interiorFm);
		ft.hide(documentFm);

		ft.commit();

		LinearLayout engineLayoutBtn = (LinearLayout) findViewById(R.id.engine_layoutBtn);
		LinearLayout powerLayoutBtn = (LinearLayout) findViewById(R.id.power_layoutBtn);
		LinearLayout allDialog = (LinearLayout) findViewById(R.id.engineLayout);
		LinearLayout exterior_layoutBtn = (LinearLayout) findViewById(R.id.exterior_layoutBtn);
		LinearLayout interior_layoutBtn = (LinearLayout) findViewById(R.id.interior_layoutBtn);
		LinearLayout document_layoutBtn = (LinearLayout) findViewById(R.id.document_layoutBtn);

		allDialog.setAlpha(0.9f);

		getPreferences(MODE_PRIVATE).edit().putInt("already", 1).commit();

		engineLayoutBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				if (prefer == 1) {
					menuIsShow[ENGINE_INDEX] = true;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();

					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.engine_motion_in,
									R.animator.engine_motion_out);
					FragmentManager fm = getFragmentManager();
					Fragment engineFm = fm.findFragmentById(R.id.engine_fm);
					ft.show(engineFm);
					ft.commit();
				} else {
					menuIsShow[ENGINE_INDEX] = false;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.engine_motion_in,
									R.animator.engine_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment engineFm = fm
							.findFragmentById(R.id.engine_fm);
					ft.hide(engineFm);
					ft.commit();
				}
			}
		});

		engineBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuIsShow[ENGINE_INDEX] = false;
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.engine_motion_in,
								R.animator.engine_motion_out);
				FragmentManager fm = getFragmentManager();
				final Fragment engineFm = fm.findFragmentById(R.id.engine_fm);
				ft.hide(engineFm);
				ft.commit();
			}
		});

		powerLayoutBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				if (prefer == 1) {
					menuIsShow[POWER_INDEX] = true;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();

					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.power_motion_in,
									R.animator.power_motion_out);
					FragmentManager fm = getFragmentManager();
					Fragment powerFm = fm.findFragmentById(R.id.power_fm);
					ft.show(powerFm);
					ft.commit();
				} else {
					menuIsShow[POWER_INDEX] = false;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.power_motion_in,
									R.animator.power_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment powerFm = fm.findFragmentById(R.id.power_fm);
					ft.hide(powerFm);
					ft.commit();
				}
			}
		});

		powerBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuIsShow[POWER_INDEX] = false;
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.power_motion_in,
								R.animator.power_motion_out);
				FragmentManager fm = getFragmentManager();
				final Fragment powerFm = fm.findFragmentById(R.id.power_fm);
				ft.hide(powerFm);
				ft.commit();
			}
		});
		// exterior

		exterior_layoutBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				if (prefer == 1) {
					menuIsShow[EXTERIOR_INDEX] = true;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();

					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.exterior_motion_in,
									R.animator.exterior_motion_out);
					FragmentManager fm = getFragmentManager();
					Fragment exteriorFm = fm.findFragmentById(R.id.exterior_fm);
					ft.show(exteriorFm);
					ft.commit();
				} else {
					menuIsShow[EXTERIOR_INDEX] = false;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.exterior_motion_in,
									R.animator.exterior_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment exteriorFm = fm
							.findFragmentById(R.id.exterior_fm);
					ft.hide(exteriorFm);
					ft.commit();
				}
			}
		});

		exteriorBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuIsShow[EXTERIOR_INDEX] = false;
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.exterior_motion_in,
								R.animator.exterior_motion_out);
				FragmentManager fm = getFragmentManager();
				final Fragment exteriorFm = fm
						.findFragmentById(R.id.exterior_fm);
				ft.hide(exteriorFm);
				ft.commit();
			}
		});

		// interior

		interior_layoutBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				if (prefer == 1) {
					menuIsShow[INTERIOR_INDEX] = true;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();

					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.exterior_motion_in,
									R.animator.exterior_motion_out);
					FragmentManager fm = getFragmentManager();
					Fragment interiorFm = fm.findFragmentById(R.id.interior_fm);
					ft.show(interiorFm);
					ft.commit();
				} else {
					menuIsShow[INTERIOR_INDEX] = false;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.exterior_motion_in,
									R.animator.exterior_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment interiorFm = fm
							.findFragmentById(R.id.interior_fm);
					ft.hide(interiorFm);
					ft.commit();
				}
			}
		});

		interiorBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuIsShow[INTERIOR_INDEX] = false;
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.exterior_motion_in,
								R.animator.exterior_motion_out);
				FragmentManager fm = getFragmentManager();
				final Fragment interiorFm = fm
						.findFragmentById(R.id.interior_fm);
				ft.hide(interiorFm);
				ft.commit();
			}
		});

		// document

		document_layoutBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int prefer = getPreferences(MODE_PRIVATE).getInt("already", 1);
				if (prefer == 1) {
					menuIsShow[DOCUMENT_INDEX] = true;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 0)
							.commit();

					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.document_motion_in,
									R.animator.document_motion_out);
					FragmentManager fm = getFragmentManager();
					Fragment documentFm = fm.findFragmentById(R.id.document_fm);
					ft.show(documentFm);
					ft.commit();
				} else {
					menuIsShow[DOCUMENT_INDEX] = false;
					getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
							.commit();
					FragmentTransaction ft = getFragmentManager()
							.beginTransaction().setCustomAnimations(
									R.animator.document_motion_in,
									R.animator.document_motion_out);
					FragmentManager fm = getFragmentManager();
					final Fragment documentFm = fm
							.findFragmentById(R.id.document_fm);
					ft.hide(documentFm);
					ft.commit();
				}
			}
		});

		documentBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuIsShow[DOCUMENT_INDEX] = false;
				getPreferences(MODE_PRIVATE).edit().putInt("already", 1)
						.commit();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction().setCustomAnimations(
								R.animator.document_motion_in,
								R.animator.document_motion_out);
				FragmentManager fm = getFragmentManager();
				final Fragment documentFm = fm
						.findFragmentById(R.id.document_fm);
				ft.hide(documentFm);
				ft.commit();
			}
		});

	}

}
