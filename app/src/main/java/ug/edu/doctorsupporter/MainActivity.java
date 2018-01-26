package ug.edu.doctorsupporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    PatientDiseases PDS;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    DbControl dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        dbc = new DbControl();
        updateBelka(1, 1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            Intent logout = new Intent(this, LoginActivity.class);
            logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logout);
        }
        if (id == R.id.action_notepad) {
            Intent notepad = new Intent(this, NotepadActivity.class);
            startActivity(notepad);
        }
        if (id == R.id.action_calendar) {
            Intent calendar = new Intent(this, CalendarActivity.class);
            startActivity(calendar);
        }


        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_patient_data, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PatientData();
                case 1:
                    return new PatientExaminations();
                case 2:
                    return new PatientHistory();
                case 3:
                    return new PatientDiseases();
                case 4:
                    return new PatientBalance();
                case 5:
                    return new PatientFoodInterview();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

    public void PacjentInfo(String imie, String nazwisko, String dataurodzenia, String Pesel) {

        TextView wyswietlImie = (TextView) findViewById(R.id.imieNazwiskoTV);


        wyswietlImie.setText(imie + ' ' + nazwisko);


        TextView wyswietlPesel = (TextView) findViewById((R.id.peselPacjentaTV));
        wyswietlPesel.setText("PESEL: " + Pesel);

    }


    public void getLekarzInfo(String imie, String nazwisko, String tytuł, String Specjalnosc_idSpecjalnosc) {

        TextView wyswietlImie = (TextView) findViewById(R.id.lekarzImieNazwiskoTV);

        wyswietlImie.setText(tytuł + ' ' + imie + ' ' + nazwisko);


    }

    public void getPacjentWiek(String wiek) {

        TextView wyswietl = (TextView) findViewById(R.id.wiekPacjentaTV);

        wyswietl.setText("Wiek: " + wiek);


    }


    public void updateBelka(int lekarzId, int pacjentId) {
        dbc.task(this, "belka", "pacjentInfo", lekarzId + "");

        dbc.task(this, "belka1", "getLekarzInfo", pacjentId + "");
        dbc.task(this, "belka2", "getPacjentWiek", pacjentId + "");
        //dbc.task(this,"belka3","getPacjentPesel",pacjentId+"");


    }


}


//        TextView wyswietlNaziwsko = (TextView) findViewById(R.id.imieNazwiskoTV);
//        wyswietlImie.setText(imie);

//    public void getPacjentPesel(String pesel) {
//
//        TextView wyswietl = (TextView) findViewById(R.id.peselPacjentaTV);
//
//        wyswietl.setText(pesel);
//
//
//    }


//    public void getChoroby(String uwagiDolegliwosc) {
//      PDS.showChoroby(uwagiDolegliwosc);
////
////        TextView wyswietl = (TextView) findViewById(R.id.uwagiChorobyTV);
////
////
////
////        wyswietl.setText(uwagiDolegliwosc);
//
////        TextView wyswietl2 = (TextView) findViewById(R.id.listOfDiseases);
//
//      //  wyswietl.setText(nazwaDolegliwosc);
//
//    }