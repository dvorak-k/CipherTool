package cz.dvorakk.ciphertool.tools;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import cz.dvorakk.ciphertool.Alphabet;
import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class LetterSumTool implements CipherTool {

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
    private Button letterA2;
    private Button letterB2;
    private Button letterC2;
    private Button letterD2;
    private Button letterE2;
    private Button letterF2;
    private Button letterG2;
    private Button letterH2;
    private Button letterI2;
    private Button letterJ2;
    private Button letterK2;
    private Button letterL2;
    private Button letterM2;
    private Button letterN2;
    private Button letterO2;
    private Button letterP2;
    private Button letterQ2;
    private Button letterR2;
    private Button letterS2;
    private Button letterT2;
    private Button letterU2;
    private Button letterV2;
    private Button letterW2;
    private Button letterX2;
    private Button letterY2;
    private Button letterZ2;
    //endregion

    private Character first;
    private Character second;

    @Override
    public int getLayoutId() {
        return R.layout.letter_sum_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.letterSumToolName;
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

        letterA2 = (Button) a.findViewById(R.id.ButtonA2);
        letterB2 = (Button) a.findViewById(R.id.ButtonB2);
        letterC2 = (Button) a.findViewById(R.id.ButtonC2);
        letterD2 = (Button) a.findViewById(R.id.ButtonD2);
        letterE2 = (Button) a.findViewById(R.id.ButtonE2);
        letterF2 = (Button) a.findViewById(R.id.ButtonF2);
        letterG2 = (Button) a.findViewById(R.id.ButtonG2);
        letterH2 = (Button) a.findViewById(R.id.ButtonH2);
        letterI2 = (Button) a.findViewById(R.id.ButtonI2);
        letterJ2 = (Button) a.findViewById(R.id.ButtonJ2);
        letterK2 = (Button) a.findViewById(R.id.ButtonK2);
        letterL2 = (Button) a.findViewById(R.id.ButtonL2);
        letterM2 = (Button) a.findViewById(R.id.ButtonM2);
        letterN2 = (Button) a.findViewById(R.id.ButtonN2);
        letterO2 = (Button) a.findViewById(R.id.ButtonO2);
        letterP2 = (Button) a.findViewById(R.id.ButtonP2);
        letterQ2 = (Button) a.findViewById(R.id.ButtonQ2);
        letterR2 = (Button) a.findViewById(R.id.ButtonR2);
        letterS2 = (Button) a.findViewById(R.id.ButtonS2);
        letterT2 = (Button) a.findViewById(R.id.ButtonT2);
        letterU2 = (Button) a.findViewById(R.id.ButtonU2);
        letterV2 = (Button) a.findViewById(R.id.ButtonV2);
        letterW2 = (Button) a.findViewById(R.id.ButtonW2);
        letterX2 = (Button) a.findViewById(R.id.ButtonX2);
        letterY2 = (Button) a.findViewById(R.id.ButtonY2);
        letterZ2 = (Button) a.findViewById(R.id.ButtonZ2);
        letterA2.setOnClickListener(secondListener);
        letterB2.setOnClickListener(secondListener);
        letterC2.setOnClickListener(secondListener);
        letterD2.setOnClickListener(secondListener);
        letterE2.setOnClickListener(secondListener);
        letterF2.setOnClickListener(secondListener);
        letterG2.setOnClickListener(secondListener);
        letterH2.setOnClickListener(secondListener);
        letterI2.setOnClickListener(secondListener);
        letterJ2.setOnClickListener(secondListener);
        letterK2.setOnClickListener(secondListener);
        letterL2.setOnClickListener(secondListener);
        letterM2.setOnClickListener(secondListener);
        letterN2.setOnClickListener(secondListener);
        letterO2.setOnClickListener(secondListener);
        letterP2.setOnClickListener(secondListener);
        letterQ2.setOnClickListener(secondListener);
        letterR2.setOnClickListener(secondListener);
        letterS2.setOnClickListener(secondListener);
        letterT2.setOnClickListener(secondListener);
        letterU2.setOnClickListener(secondListener);
        letterV2.setOnClickListener(secondListener);
        letterW2.setOnClickListener(secondListener);
        letterX2.setOnClickListener(secondListener);
        letterY2.setOnClickListener(secondListener);
        letterZ2.setOnClickListener(secondListener);

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
        letterA.setOnClickListener(firstListener);
        letterB.setOnClickListener(firstListener);
        letterC.setOnClickListener(firstListener);
        letterD.setOnClickListener(firstListener);
        letterE.setOnClickListener(firstListener);
        letterF.setOnClickListener(firstListener);
        letterG.setOnClickListener(firstListener);
        letterH.setOnClickListener(firstListener);
        letterI.setOnClickListener(firstListener);
        letterJ.setOnClickListener(firstListener);
        letterK.setOnClickListener(firstListener);
        letterL.setOnClickListener(firstListener);
        letterM.setOnClickListener(firstListener);
        letterN.setOnClickListener(firstListener);
        letterO.setOnClickListener(firstListener);
        letterP.setOnClickListener(firstListener);
        letterQ.setOnClickListener(firstListener);
        letterR.setOnClickListener(firstListener);
        letterS.setOnClickListener(firstListener);
        letterT.setOnClickListener(firstListener);
        letterU.setOnClickListener(firstListener);
        letterV.setOnClickListener(firstListener);
        letterW.setOnClickListener(firstListener);
        letterX.setOnClickListener(firstListener);
        letterY.setOnClickListener(firstListener);
        letterZ.setOnClickListener(firstListener);
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

    private OnClickListener firstListener = new OnClickListener() {
        public void onClick(View v) {
            first = ((Button) v).getText().charAt(0);
            firstText.setText(first.toString());
            compute();
        }
    };

    private OnClickListener secondListener = new OnClickListener() {
        public void onClick(View v) {
            second = ((Button) v).getText().charAt(0);
            secondText.setText(second.toString());
            compute();
        }
    };

    protected int getAIndex() {
        if (aIndex.isChecked())
            return 1;
        else
            return 0;
    }

    protected void compute() {
        outputText.setText("");
        outputNumberText.setText("");

        if (first == null)
            return;

        if (second == null)
            return;

        Alphabet alphabet = new Alphabet(getAIndex());
        int firstIndex = alphabet.getIndexByChar(first);
        int secondIndex = alphabet.getIndexByChar(second);

        int result = alphabet.shiftAsIndex(firstIndex, secondIndex, encodeButton.isChecked());
        outputText.setText(String.valueOf(alphabet.getCharByIndex(result)));
        outputNumberText.setText(String.valueOf(result));
    }
}


