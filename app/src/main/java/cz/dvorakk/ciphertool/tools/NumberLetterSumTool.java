package cz.dvorakk.ciphertool.tools;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import cz.dvorakk.ciphertool.Alphabet;
import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class NumberLetterSumTool implements CipherTool {

    //region layout controls
    private RadioButton decodeButton;
    private RadioButton encodeButton;
    private TextView outputText;
    private TextView outputNumberText;
    private TextView firstText;
    private TextView secondText;
    private CheckBox aIndex;
    private Button letterA;
    private Button letterB;
    private Button letterC;
    private Button letterD;
    private Button letterE;
    private Button letterF;
    private Button letterG;
    private Button letterH;
    private Button letterI;
    private Button letterJ;
    private Button letterK;
    private Button letterL;
    private Button letterM;
    private Button letterN;
    private Button letterO;
    private Button letterP;
    private Button letterQ;
    private Button letterR;
    private Button letterS;
    private Button letterT;
    private Button letterU;
    private Button letterV;
    private Button letterW;
    private Button letterX;
    private Button letterY;
    private Button letterZ;
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
    //endregion

    private Character letter;
    private int tenths = 0;
    private int ones = 0;
    private int number = 0;

    @Override
    public int getLayoutId() {
        return R.layout.number_letter_sum_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.numberLetterSumToolName;
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

        letterA = (Button) a.findViewById(R.id.ButtonA);
        letterB = (Button) a.findViewById(R.id.ButtonB);
        letterC = (Button) a.findViewById(R.id.ButtonC);
        letterD = (Button) a.findViewById(R.id.ButtonD);
        letterE = (Button) a.findViewById(R.id.ButtonE);
        letterF = (Button) a.findViewById(R.id.ButtonF);
        letterG = (Button) a.findViewById(R.id.ButtonG);
        letterH = (Button) a.findViewById(R.id.ButtonH);
        letterI = (Button) a.findViewById(R.id.ButtonI);
        letterJ = (Button) a.findViewById(R.id.ButtonJ);
        letterK = (Button) a.findViewById(R.id.ButtonK);
        letterL = (Button) a.findViewById(R.id.ButtonL);
        letterM = (Button) a.findViewById(R.id.ButtonM);
        letterN = (Button) a.findViewById(R.id.ButtonN);
        letterO = (Button) a.findViewById(R.id.ButtonO);
        letterP = (Button) a.findViewById(R.id.ButtonP);
        letterQ = (Button) a.findViewById(R.id.ButtonQ);
        letterR = (Button) a.findViewById(R.id.ButtonR);
        letterS = (Button) a.findViewById(R.id.ButtonS);
        letterT = (Button) a.findViewById(R.id.ButtonT);
        letterU = (Button) a.findViewById(R.id.ButtonU);
        letterV = (Button) a.findViewById(R.id.ButtonV);
        letterW = (Button) a.findViewById(R.id.ButtonW);
        letterX = (Button) a.findViewById(R.id.ButtonX);
        letterY = (Button) a.findViewById(R.id.ButtonY);
        letterZ = (Button) a.findViewById(R.id.ButtonZ);
        letterA.setOnClickListener(letterListener);
        letterB.setOnClickListener(letterListener);
        letterC.setOnClickListener(letterListener);
        letterD.setOnClickListener(letterListener);
        letterE.setOnClickListener(letterListener);
        letterF.setOnClickListener(letterListener);
        letterG.setOnClickListener(letterListener);
        letterH.setOnClickListener(letterListener);
        letterI.setOnClickListener(letterListener);
        letterJ.setOnClickListener(letterListener);
        letterK.setOnClickListener(letterListener);
        letterL.setOnClickListener(letterListener);
        letterM.setOnClickListener(letterListener);
        letterN.setOnClickListener(letterListener);
        letterO.setOnClickListener(letterListener);
        letterP.setOnClickListener(letterListener);
        letterQ.setOnClickListener(letterListener);
        letterR.setOnClickListener(letterListener);
        letterS.setOnClickListener(letterListener);
        letterT.setOnClickListener(letterListener);
        letterU.setOnClickListener(letterListener);
        letterV.setOnClickListener(letterListener);
        letterW.setOnClickListener(letterListener);
        letterX.setOnClickListener(letterListener);
        letterY.setOnClickListener(letterListener);
        letterZ.setOnClickListener(letterListener);

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

    private OnClickListener letterListener = new OnClickListener() {
        public void onClick(View v) {
            letter = ((Button) v).getText().charAt(0);
            secondText.setText(letter.toString());
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

    protected int getAIndex() {
        if (aIndex.isChecked())
            return 1;
        else
            return 0;
    }

    protected void compute() {
        outputText.setText("");
        outputNumberText.setText("");

        if (letter == null)
            return;

        Alphabet alphabet = new Alphabet(getAIndex());
        int numberIndex = number;
        int shift = alphabet.getIndexByChar(letter);

        int result = alphabet.shiftAsIndex(numberIndex, shift, encodeButton.isChecked());
        outputText.setText(String.valueOf(alphabet.getCharByIndex(result)));
        outputNumberText.setText(String.valueOf(result));
    }
}


