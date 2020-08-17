package sg.edu.rp.c346.id18015170.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCat;
    Spinner spnSubCat;
    Button btnGo;
    ArrayList<String> alSubCat;
    ArrayAdapter<String> aaSubCat;

    WebView wvRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCat = findViewById(R.id.spinnerCategory);
        spnSubCat = findViewById(R.id.spinnerSubCat);
        btnGo = findViewById(R.id.buttonGo);
        wvRP = findViewById(R.id.webViewRP);

        alSubCat = new ArrayList<>();
        aaSubCat = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alSubCat);
        // bind arrayAdapter to spinner
        spnSubCat.setAdapter(aaSubCat);


        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alSubCat.clear();

                if(position == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.subCatRP);

                    //Convert Array to List and add to the ArrayList
                    alSubCat.addAll(Arrays.asList(strNumbers));
                }
                else{
                    String[] strNumbers = getResources().getStringArray(R.array.subCatSOI);

                    //Convert Array to List and add to the ArrayList
                    alSubCat.addAll(Arrays.asList(strNumbers));

                }
                aaSubCat.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        wvRP.setWebViewClient(new WebViewClient());
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (spnCat.getSelectedItemPosition() == 0){ // RP
                    if(spnSubCat.getSelectedItemPosition() == 0){
                        wvRP.loadUrl("https://www.rp.edu.sg/");
                    }
                    else{
                        wvRP.loadUrl("https://www.rp.edu.sg/student-life");
                    }
                }
                else if(spnCat.getSelectedItemPosition() == 1){
                    if(spnSubCat.getSelectedItemPosition() == 0){
                        wvRP.loadUrl("https://www.rp.edu.sg/full-time-diplomas/details/r47");
                    }
                    else{
                        wvRP.loadUrl("https://www.rp.edu.sg/full-time-diplomas/details/r12");
                    }
                }
            }
        });
    }
}
