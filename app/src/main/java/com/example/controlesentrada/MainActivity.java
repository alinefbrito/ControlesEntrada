package com.example.controlesentrada;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    ToggleButton toggle;
    Switch switcher;
    RadioButton rbd1, rbd2,rbd3;
    CheckBox chk1, chk2,chk3;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado  = findViewById(R.id.textView3);
        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        switcher = findViewById(R.id.swtValor);
        rbd1 = findViewById(R.id.rdBtn1);
        rbd2 = findViewById(R.id.rdBtn2);
        rbd3 = findViewById(R.id.rdBtn3);
        chk1 = findViewById(R.id.chkValor1);
        chk2 = findViewById(R.id.chkValor2);
        chk3 = findViewById(R.id.chkValor3);
        //adiciona a ação de um evento via código
        // se não for definido nas propriedades do elemento deve constar no onCreate
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    resultado.setText("Toggle Button Ligado");
                } else {
                    resultado.setText("Toggle Button Desligado");
                }
            }
        });
        sp=findViewById(R.id.spinnerCores);
    }
    public void spinerAddItens() {

       //cria uma lista que receberá os valores
        List<String> list = new ArrayList<String>();
        list.add("Vermelho");
        list.add("Verde");
        list.add("Azul");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
        
    }
    public void botaoClick(View v)
    {
        resultado.setText(R.string.txtBotao);
    }
    public void checkboxClick(View view) {

        String check = "";

        if (chk1.isChecked()) {
            check = check.concat("Checkbox 1 Selecionado \n");
        }

        if (chk2.isChecked()) {
            check = check.concat("Checkbox 2 Selecionado \n");
        }
        if (chk3.isChecked()) {
            check = check.concat("Checkbox 3 Selecionado \n");
        }
        if (check.equals(""))
            check = " Nenhum checkbox foi selecionado";


        resultado.setText(check);
    }

    public void radioBtnClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String check = "";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdBtn1:
                if (checked)
                {
                    check = check.concat("Radio Button 1 Selecionado \n");
                }
                    break;
            case R.id.rdBtn2:
                if (checked)
                {
                    check = check.concat("Radio Button 2 Selecionado \n");
                }
                break;
                case R.id.rdBtn3:
                if (checked)
                {
                    check = check.concat("Radio Button 3 Selecionado \n");
                }
                break;
        }
        resultado.setText(check);
    }
public void switchClick(View v)
{
    if (switcher.isChecked())
        resultado.setText("Switch Ligado");
    else
        resultado.setText("Switch Desligado");

}

}