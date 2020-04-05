package com.example.autojobbd;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ToggleButton toggleButton;
    DatePickerDialog.OnDateSetListener dobDatePickerListener;
    DatePickerDialog.OnDateSetListener expStartDatePickerListener;
    DatePickerDialog.OnDateSetListener expEndDatePickerListener;
    SimpleDateFormat sdf;
    EditText nameEditText, fathersNameEditText, mothersNameEditText, nidEditText, birthCerEditText,
            passportEditText, villPresentEditText, postOffPresentEditText, postalCodePresentEditText,
            mobileNoEditText, confMobileNoEditText, emailEditText, sscRollEditText, hscRollEditText,
            villPermanentEditText, postOffPermanentEditText, postalCodePermanentEditText,
            expDesignationEditText, expOrganizEditText, expResponEditText;
    //testing
    EditText dobDatepicker, expStartDatePicker, expEndDatePicker;
    Calendar dobCalendar = Calendar.getInstance();
    Calendar expStartCalender = Calendar.getInstance();
    Calendar expEndCalender = Calendar.getInstance();
    //===============
    Spinner nationalitySpn, religionSpn, presentDistSpn,
            presentPSSpn, permanentDistSpn, permanentPSSpn, sscExamSpn, sscBoardSpn, sscResultSpn,
            sscGroupSpn, sscPassingYearSpn, hscExamSpn, hscBoardSpn, hscResultSpn,
            hscGroupSpn, hscPassingYearSpn, gradExamSpn, gradSubSpn, gradInstSpn, gradResultSpn,
            gradPassingYearSpn, gradDurationSpn, mastExamSpn, mastSubSpn, mastInstSpn, mastResultSpn,
            mastPassingYearSpn, mastDurationSpn;
    RadioGroup genderRadioGroup, maritalStsRadioGroup;
    RadioButton maleRadioBtn, femaleRadioBtn, othersRadioBtn, marriedRadioBtn, singleRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        linearLayout = findViewById(R.id.layoutId);


        viewFindings();
        spinnerSets();
        datePickerView();

    }

    private void datePickerView(){
        dobDatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterActivity.this, dobDatePickerListener, dobCalendar
                        .get(Calendar.YEAR), dobCalendar.get(Calendar.MONTH),
                        dobCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dobDatePickerListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                dobCalendar.set(Calendar.YEAR, year);
                dobCalendar.set(Calendar.MONTH, monthOfYear);
                dobCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yyyy";
                sdf = new SimpleDateFormat(myFormat, Locale.CHINA);
                dobDatepicker.setText(sdf.format(dobCalendar.getTime()));
            }

        };
        //experience start field===========================

        expStartDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegisterActivity.this, expStartDatePickerListener, expStartCalender
                        .get(Calendar.YEAR), expStartCalender.get(Calendar.MONTH),
                        expStartCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        expStartDatePickerListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                expStartCalender.set(Calendar.YEAR, year);
                expStartCalender.set(Calendar.MONTH, monthOfYear);
                expStartCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yyyy";
                sdf = new SimpleDateFormat(myFormat, Locale.CHINA);
                expStartDatePicker.setText(sdf.format(expStartCalender.getTime()));
            }

        };
        //experience end field==========================
        expEndDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegisterActivity.this, expEndDatePickerListener, expEndCalender
                        .get(Calendar.YEAR), expEndCalender.get(Calendar.MONTH),
                        expEndCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        expEndDatePickerListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                expEndCalender.set(Calendar.YEAR, year);
                expEndCalender.set(Calendar.MONTH, monthOfYear);
                expEndCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yyyy";
                sdf = new SimpleDateFormat(myFormat, Locale.CHINA);
                expEndDatePicker.setText(sdf.format(expEndCalender.getTime()));
            }

        };


    }

    private void spinnerSets(){

        ArrayAdapter<CharSequence> nationalityAdapter = ArrayAdapter.createFromResource(this, R.array.nationality_array, android.R.layout.simple_spinner_item);
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nationalitySpn.setAdapter(nationalityAdapter);

        ArrayAdapter<CharSequence> religionAdapter = ArrayAdapter.createFromResource(this, R.array.religion_array, android.R.layout.simple_spinner_item);
        religionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religionSpn.setAdapter(religionAdapter);

        ArrayAdapter<CharSequence> sscExamAdapter = ArrayAdapter.createFromResource(this, R.array.ssc_exam_array,android.R.layout.simple_spinner_item);
        sscExamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sscExamSpn.setAdapter(sscExamAdapter);

        ArrayAdapter<CharSequence> presentDistrictAdapter = ArrayAdapter.createFromResource(this, R.array.district_array, android.R.layout.simple_spinner_item);
        presentDistrictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        presentDistSpn.setAdapter(presentDistrictAdapter);
        presentDistSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                permanentThanaSpinnerSet();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> permanentDistrictAdapter = ArrayAdapter.createFromResource(this, R.array.district_array, android.R.layout.simple_spinner_item);
        permanentDistrictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        permanentDistSpn.setAdapter(permanentDistrictAdapter);
        permanentDistSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presentThanaSpinnerSet();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
    public void presentThanaSpinnerSet(){
        int thanaArray = R.array.blank_array;
        if (permanentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Faridpur")){
            thanaArray = R.array.faridpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Gazipur")){
            thanaArray = R.array.gazipur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Gopalganj")){
            thanaArray = R.array.gopalganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Jamalpur")){
            thanaArray = R.array.jamalpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Kishoreganj")){
            thanaArray = R.array.kishoreganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Madaripur")){
            thanaArray = R.array.madaripur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Manikganj")){
            thanaArray = R.array.manikganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Munshiganj")){
            thanaArray = R.array.munshiganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Mymensingh")){
            thanaArray = R.array.mymensingh_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Narsingdi")){
            thanaArray = R.array.narsingdi_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Netrokona")){
            thanaArray = R.array.netrakona_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Rajbari")){
            thanaArray = R.array.rajbari_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Shariatpur")){
            thanaArray = R.array.shariatpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Sherpur")){
            thanaArray = R.array.sherpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Tangail")){
            thanaArray = R.array.tangail_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Bogura")){
            thanaArray = R.array.bogura_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Joypurhat")){
            thanaArray = R.array.joypurhat_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Naogaon")){
            thanaArray = R.array.naogaon_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Natore")){
            thanaArray = R.array.natore_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Chapai Nababganj")){
            thanaArray = R.array.chapai_nababganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Pabna")){
            thanaArray = R.array.pabna_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Rajshahi")){
            thanaArray = R.array.rajshahi_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Sirajgonj")){
            thanaArray = R.array.sirajganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Dinajpur")){
            thanaArray = R.array.dinajpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Gaibandha")){
            thanaArray = R.array.gaibandha_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Kurigram")){
            thanaArray = R.array.kurigram_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Lalmonirhat")){
            thanaArray = R.array.lalmonirhat_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Nilphamari")){
            thanaArray = R.array.nilphamari_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Panchagarh")){
            thanaArray = R.array.rangpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Rangpur")){
            thanaArray = R.array.dhaka_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Thakurgaon")){
            thanaArray = R.array.thakurgaon_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Barguna")){
            thanaArray = R.array.barguna_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Barishal")){
            thanaArray = R.array.barisal_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Bhola")){
            thanaArray = R.array.bhola_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Jhalokati")){
            thanaArray = R.array.jalokati_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Patuakhali")){
            thanaArray = R.array.patuakhali_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Pirojpur")){
            thanaArray = R.array.pirojpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Bandarban")){
            thanaArray = R.array.bandarban_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Brahmanbaria")){
            thanaArray = R.array.brahmanbaria_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Chandpur")){
            thanaArray = R.array.chandpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Chattogram")){
            thanaArray = R.array.chattagram_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Cumilla")){
            thanaArray = R.array.cumilla_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Coxs Bazar")){
            thanaArray = R.array.coxsbazar_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Feni")){
            thanaArray = R.array.feni_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Khagrachari")){
            thanaArray = R.array.khagrachhari_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Lakshmipur")){
            thanaArray = R.array.lakshmipur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Noakhali")){
            thanaArray = R.array.noakhali_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Rangamati")){
            thanaArray = R.array.rangamati_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Habiganj")){
            thanaArray = R.array.habiganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Maulvibazar")){
            thanaArray = R.array.maulavibazar_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Sunamganj")){
            thanaArray = R.array.sunamganj_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Sylhet")){
            thanaArray = R.array.sylhet_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Bagerhat")){
            thanaArray = R.array.bagerhat_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Chuadanga")){
            thanaArray = R.array.dhaka_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Jashore")){
            thanaArray = R.array.jashore_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Jhenaidah")){
            thanaArray = R.array.jhenaidah_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Khulna")){
            thanaArray = R.array.khulna_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Kushtia")){
            thanaArray = R.array.kushtia_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Magura")){
            thanaArray = R.array.magura_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Meherpur")){
            thanaArray = R.array.meherpur_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Narail")){
            thanaArray = R.array.narail_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }else if (permanentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }
        ArrayAdapter<CharSequence> thanaAdapter = ArrayAdapter.createFromResource(this, thanaArray, android.R.layout.simple_spinner_item);
        thanaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        permanentPSSpn.setAdapter(thanaAdapter);

    }
    public void permanentThanaSpinnerSet(){
        int thanaArray = R.array.blank_array;
        if (presentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Faridpur")){
            thanaArray = R.array.faridpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Gazipur")){
            thanaArray = R.array.gazipur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Gopalganj")){
            thanaArray = R.array.gopalganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Jamalpur")){
            thanaArray = R.array.jamalpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Kishoreganj")){
            thanaArray = R.array.kishoreganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Madaripur")){
            thanaArray = R.array.madaripur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Manikganj")){
            thanaArray = R.array.manikganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Munshiganj")){
            thanaArray = R.array.munshiganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Mymensingh")){
            thanaArray = R.array.mymensingh_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Narsingdi")){
            thanaArray = R.array.narsingdi_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Netrokona")){
            thanaArray = R.array.netrakona_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Rajbari")){
            thanaArray = R.array.rajbari_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Shariatpur")){
            thanaArray = R.array.shariatpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Sherpur")){
            thanaArray = R.array.sherpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Tangail")){
            thanaArray = R.array.tangail_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Bogura")){
            thanaArray = R.array.bogura_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Joypurhat")){
            thanaArray = R.array.joypurhat_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Naogaon")){
            thanaArray = R.array.naogaon_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Natore")){
            thanaArray = R.array.natore_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Chapai Nababganj")){
            thanaArray = R.array.chapai_nababganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Pabna")){
            thanaArray = R.array.pabna_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Rajshahi")){
            thanaArray = R.array.rajshahi_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Sirajgonj")){
            thanaArray = R.array.sirajganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Dinajpur")){
            thanaArray = R.array.dinajpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Gaibandha")){
            thanaArray = R.array.gaibandha_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Kurigram")){
            thanaArray = R.array.kurigram_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Lalmonirhat")){
            thanaArray = R.array.lalmonirhat_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Nilphamari")){
            thanaArray = R.array.nilphamari_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Panchagarh")){
            thanaArray = R.array.rangpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Rangpur")){
            thanaArray = R.array.dhaka_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Thakurgaon")){
            thanaArray = R.array.thakurgaon_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Barguna")){
            thanaArray = R.array.barguna_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Barishal")){
            thanaArray = R.array.barisal_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Bhola")){
            thanaArray = R.array.bhola_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Jhalokati")){
            thanaArray = R.array.jalokati_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Patuakhali")){
            thanaArray = R.array.patuakhali_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Pirojpur")){
            thanaArray = R.array.pirojpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Bandarban")){
            thanaArray = R.array.bandarban_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Brahmanbaria")){
            thanaArray = R.array.brahmanbaria_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Chandpur")){
            thanaArray = R.array.chandpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Chattogram")){
            thanaArray = R.array.chattagram_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Cumilla")){
            thanaArray = R.array.cumilla_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Coxs Bazar")){
            thanaArray = R.array.coxsbazar_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Feni")){
            thanaArray = R.array.feni_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Khagrachari")){
            thanaArray = R.array.khagrachhari_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Lakshmipur")){
            thanaArray = R.array.lakshmipur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Noakhali")){
            thanaArray = R.array.noakhali_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Rangamati")){
            thanaArray = R.array.rangamati_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Habiganj")){
            thanaArray = R.array.habiganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Maulvibazar")){
            thanaArray = R.array.maulavibazar_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Sunamganj")){
            thanaArray = R.array.sunamganj_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Sylhet")){
            thanaArray = R.array.sylhet_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Bagerhat")){
            thanaArray = R.array.bagerhat_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Chuadanga")){
            thanaArray = R.array.dhaka_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Jashore")){
            thanaArray = R.array.jashore_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Jhenaidah")){
            thanaArray = R.array.jhenaidah_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Khulna")){
            thanaArray = R.array.khulna_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Kushtia")){
            thanaArray = R.array.kushtia_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Magura")){
            thanaArray = R.array.magura_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Meherpur")){
            thanaArray = R.array.meherpur_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Narail")){
            thanaArray = R.array.narail_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }else if (presentDistSpn.getSelectedItem().toString().equals("Dhaka")){
            thanaArray = R.array.dhaka_array;
        }
        ArrayAdapter<CharSequence> thanaAdapter = ArrayAdapter.createFromResource(this, thanaArray, android.R.layout.simple_spinner_item);
        thanaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        presentPSSpn.setAdapter(thanaAdapter);

    }

    private void viewFindings(){
        //EditText finding===============
        nameEditText = findViewById(R.id.nameId);
        fathersNameEditText = findViewById(R.id.fathersNameId);
        mothersNameEditText = findViewById(R.id.mothersNameId);
        nidEditText = findViewById(R.id.nidNoId);
        birthCerEditText = findViewById(R.id.birthRegId);
        passportEditText = findViewById(R.id.passportNoId);
        villPresentEditText = findViewById(R.id.presentVillId);
        postOffPresentEditText = findViewById(R.id.presentPOId);
        postalCodePresentEditText = findViewById(R.id.presentPostalCodeId);
        mobileNoEditText = findViewById(R.id.mobileNoId);
        confMobileNoEditText = findViewById(R.id.confMobileNoId);
        emailEditText = findViewById(R.id.emailEtId);
        sscRollEditText = findViewById(R.id.sscRollId);
        hscRollEditText = findViewById(R.id.hscRollId);
        villPermanentEditText = findViewById(R.id.permanentVillId);
        postOffPermanentEditText = findViewById(R.id.pernamentPostOffId);
        postalCodePermanentEditText = findViewById(R.id.permanentPostalId);
        expDesignationEditText = findViewById(R.id.expDesignationId);
        expOrganizEditText = findViewById(R.id.expOrganizId);
        expResponEditText = findViewById(R.id.expResponsId);
        //Spinner finding=================
        nationalitySpn = findViewById(R.id.nationalitySpnId);
        religionSpn = findViewById(R.id.religionSpnId);
        presentDistSpn = findViewById(R.id.presentDistId);
        presentPSSpn = findViewById(R.id.presentPSId);
        permanentDistSpn = findViewById(R.id.permanentDistId);
        permanentPSSpn = findViewById(R.id.permanentPSId);
        sscExamSpn = findViewById(R.id.sscExamId);
        sscBoardSpn= findViewById(R.id.sscBoardId);
        sscResultSpn = findViewById(R.id.sscResultId);
        sscGroupSpn = findViewById(R.id.sscGroupId);
        sscPassingYearSpn = findViewById(R.id.sscPassingYearId);
        hscExamSpn = findViewById(R.id.hscExamId);
        hscBoardSpn= findViewById(R.id.hscBoardId);
        hscResultSpn = findViewById(R.id.hscResultId);
        hscGroupSpn = findViewById(R.id.hscGroupId);
        hscPassingYearSpn = findViewById(R.id.hscPassingYearId);
        gradExamSpn = findViewById(R.id.gradExamId);
        gradSubSpn = findViewById(R.id.gradSubId);
        gradInstSpn = findViewById(R.id.gradInstId);
        gradResultSpn = findViewById(R.id.gradResultId);
        gradPassingYearSpn = findViewById(R.id.gradPassingYearId);
        gradDurationSpn = findViewById(R.id.gradDurationId);
        mastExamSpn = findViewById(R.id.mastersExamId);
        mastSubSpn = findViewById(R.id.mastersSubId);
        mastInstSpn = findViewById(R.id.mastersInstId);
        mastResultSpn = findViewById(R.id.mastersResultId);
        mastPassingYearSpn = findViewById(R.id.mastersPassingYearId);
        mastDurationSpn = findViewById(R.id.mastersDurationId);
        //RadioGroup and RadioButton Finding ============
        genderRadioGroup = findViewById(R.id.genderRadioGrpId);
        maritalStsRadioGroup = findViewById(R.id.maritalRadioGrpId);
        maleRadioBtn = findViewById(R.id.maleRadioId);
        femaleRadioBtn = findViewById(R.id.femaleRadioId);
        othersRadioBtn = findViewById(R.id.otherGenderRadioId);
        marriedRadioBtn = findViewById(R.id.marriedRadioId);
        singleRadioBtn = findViewById(R.id.singleRadioId);
        //datePicking ET
        dobDatepicker = findViewById(R.id.dobDatePicker);
        expStartDatePicker = findViewById(R.id.expStartDate);
        expEndDatePicker = findViewById(R.id.expEndDate);

    }


    public void changeColor(View view) {
        toggleButton = findViewById(R.id.toggleButtonId);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout.setBackgroundColor(Color.GREEN);
                }else {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

    }
}





