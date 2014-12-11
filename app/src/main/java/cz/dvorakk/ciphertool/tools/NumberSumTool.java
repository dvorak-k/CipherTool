package cz.dvorakk.ciphertool.tools;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import cz.dvorakk.ciphertool.Alphabet;
import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class NumberSumTool implements CipherTool {

    //region layout controls
    private RadioButton decodeButton;
    private RadioButton encodeButton;
    private TextView outputText;
    private TextView outputNumberText;
    private TextView firstText;
    private TextView secondText;
    private CheckBox aIndex;

    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button number20;
    private Button number21;
    private Button number22;
    private Button number23;
    private Button number24;
    private Button number25;
    private Button number26;
    private Button number27;
    private Button number28;
    private Button number29;
    private Button number30;
    private Button number31;
    private Button number32;
    private Button number33;
    private Button number34;
    private Button number35;
    private Button number36;
    private Button number37;
    private Button number38;
    private Button number39;
    private Button number40;
    private Button number41;
    private Button number42;
    private Button number43;
    private Button number44;
    private Button number45;
    private Button number46;
    private Button number47;
    private Button number48;
    private Button number49;
    //endregion

    private int tenths = 0;
    private int ones = 0;
    private int number = 0;

    private int tenths2 = 0;
    private int ones2 = 0;
    private int num2 = 0;

    @Override
    public int getLayoutId() {
        return R.layout.number_sum_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.numberSumToolName;
    }

    @Override
    public void init(Activity a) {
        decodeButton = (RadioButton) a.findViewById(R.id.decodeRadio);
        encodeButton = (RadioButton) a.findViewById(R.id.encodeRadio);
        decodeButton.setOnClickListener(radio_listener);
        encodeButton.setOnClickListener(radio_listener);
        outputText = (TextView) a.findViewById(R.id.outputText);
        outputNumberText = (TextView) a.findViewById(R.id.outputNumberText);
        aIndex = (CheckBox) a.findViewById(R.id.aIndexCheckbox);
        aIndex.setOnClickListener(aIndexOnClickListener);

        firstText = (TextView) a.findViewById(R.id.firstText);
        secondText = (TextView) a.findViewById(R.id.secondText);

        number0 = (Button) a.findViewById(R.id.Number0);
        number1 = (Button) a.findViewById(R.id.Number1);
        number2 = (Button) a.findViewById(R.id.Number2);
        number3 = (Button) a.findViewById(R.id.Number3);
        number4 = (Button) a.findViewById(R.id.Number4);
        number5 = (Button) a.findViewById(R.id.Number5);
        number6 = (Button) a.findViewById(R.id.Number6);
        number7 = (Button) a.findViewById(R.id.Number7);
        number8 = (Button) a.findViewById(R.id.Number8);
        number9 = (Button) a.findViewById(R.id.Number9);

        number0.setOnClickListener(tenthListener);
        number1.setOnClickListener(tenthListener);
        number2.setOnClickListener(tenthListener);
        number3.setOnClickListener(tenthListener);
        number4.setOnClickListener(tenthListener);
        number5.setOnClickListener(tenthListener);
        number6.setOnClickListener(tenthListener);
        number7.setOnClickListener(tenthListener);
        number8.setOnClickListener(tenthListener);
        number9.setOnClickListener(tenthListener);

        number20 = (Button) a.findViewById(R.id.Number20);
        number21 = (Button) a.findViewById(R.id.Number21);
        number22 = (Button) a.findViewById(R.id.Number22);
        number23 = (Button) a.findViewById(R.id.Number23);
        number24 = (Button) a.findViewById(R.id.Number24);
        number25 = (Button) a.findViewById(R.id.Number25);
        number26 = (Button) a.findViewById(R.id.Number26);
        number27 = (Button) a.findViewById(R.id.Number27);
        number28 = (Button) a.findViewById(R.id.Number28);
        number29 = (Button) a.findViewById(R.id.Number29);

        number20.setOnClickListener(onesListener);
        number21.setOnClickListener(onesListener);
        number22.setOnClickListener(onesListener);
        number23.setOnClickListener(onesListener);
        number24.setOnClickListener(onesListener);
        number25.setOnClickListener(onesListener);
        number26.setOnClickListener(onesListener);
        number27.setOnClickListener(onesListener);
        number28.setOnClickListener(onesListener);
        number29.setOnClickListener(onesListener);


        number30 = (Button) a.findViewById(R.id.Number30);
        number31 = (Button) a.findViewById(R.id.Number31);
        number32 = (Button) a.findViewById(R.id.Number32);
        number33 = (Button) a.findViewById(R.id.Number33);
        number34 = (Button) a.findViewById(R.id.Number34);
        number35 = (Button) a.findViewById(R.id.Number35);
        number36 = (Button) a.findViewById(R.id.Number36);
        number37 = (Button) a.findViewById(R.id.Number37);
        number38 = (Button) a.findViewById(R.id.Number38);
        number39 = (Button) a.findViewById(R.id.Number39);

        number30.setOnClickListener(tenthListener2);
        number31.setOnClickListener(tenthListener2);
        number32.setOnClickListener(tenthListener2);
        number33.setOnClickListener(tenthListener2);
        number34.setOnClickListener(tenthListener2);
        number35.setOnClickListener(tenthListener2);
        number36.setOnClickListener(tenthListener2);
        number37.setOnClickListener(tenthListener2);
        number38.setOnClickListener(tenthListener2);
        number39.setOnClickListener(tenthListener2);

        number40 = (Button) a.findViewById(R.id.Number40);
        number41 = (Button) a.findViewById(R.id.Number41);
        number42 = (Button) a.findViewById(R.id.Number42);
        number43 = (Button) a.findViewById(R.id.Number43);
        number44 = (Button) a.findViewById(R.id.Number44);
        number45 = (Button) a.findViewById(R.id.Number45);
        number46 = (Button) a.findViewById(R.id.Number46);
        number47 = (Button) a.findViewById(R.id.Number47);
        number48 = (Button) a.findViewById(R.id.Number48);
        number49 = (Button) a.findViewById(R.id.Number49);

        number40.setOnClickListener(onesListener2);
        number41.setOnClickListener(onesListener2);
        number42.setOnClickListener(onesListener2);
        number43.setOnClickListener(onesListener2);
        number44.setOnClickListener(onesListener2);
        number45.setOnClickListener(onesListener2);
        number46.setOnClickListener(onesListener2);
        number47.setOnClickListener(onesListener2);
        number48.setOnClickListener(onesListener2);
        number49.setOnClickListener(onesListener2);
    }

    private OnClickListener radio_listener = new OnClickListener() {
        public void onClick(View v) {
            compute();
        }
    };


    private OnClickListener aIndexOnClickListener = new OnClickListener() {
        public void onClick(View v) {
            compute();
        }
    };

    private OnClickListener tenthListener = new OnClickListener() {
        public void onClick(View v) {
            String t = ((Button) v).getText().toString();
            tenths = Integer.parseInt(t);
            computeNumber();
        }
    };

    private OnClickListener onesListener = new OnClickListener() {
        public void onClick(View v) {
            String o = ((Button) v).getText().toString();
            ones = Integer.parseInt(o);
            computeNumber();
        }
    };

    private void computeNumber() {
        number = tenths * 10 + ones;
        firstText.setText("" + number);
        compute();
    }


    private OnClickListener tenthListener2 = new OnClickListener() {
        public void onClick(View v) {
            String t = ((Button) v).getText().toString();
            tenths2 = Integer.parseInt(t);
            computeNumber2();
        }
    };

    private OnClickListener onesListener2 = new OnClickListener() {
        public void onClick(View v) {
            String o = ((Button) v).getText().toString();
            ones2 = Integer.parseInt(o);
            computeNumber2();
        }
    };

    private void computeNumber2() {
        num2 = tenths2 * 10 + ones2;
        secondText.setText("" + num2);
        compute();
    }


    protected int getAIndex() {
        if (aIndex.isChecked())
            return 1;
        else
            return 0;
    }

    protected void compute() {
        outputText.setText("");
        outputNumberText.setText("");

        Alphabet alphabet = new Alphabet(getAIndex());
        int numIndex = number;
        int shift = num2;

        int result = alphabet.shiftAsIndex(numIndex, shift, encodeButton.isChecked());
        outputText.setText(String.valueOf(alphabet.getCharByIndex(result)));
        outputNumberText.setText(String.valueOf(result));
    }
}


