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

public class WordSumTool implements CipherTool {

    protected RadioButton decodeButton;
    protected RadioButton encodeButton;
    protected Button actionButton;
    protected TextView inputLabel;
    protected TextView inputText;
    protected TextView outputText;
    protected TextView passwordText;
    protected CheckBox aIndex;

    @Override
    public int getLayoutId() {
        return R.layout.word_sum_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.wordSumToolName;
    }

    @Override
    public void init(Activity activity) {
        decodeButton = (RadioButton) activity.findViewById(R.id.decodeRadio);
        encodeButton = (RadioButton) activity.findViewById(R.id.encodeRadio);
        actionButton = (Button) activity.findViewById(R.id.decodeButton);
        inputLabel = (TextView) activity.findViewById(R.id.inputLabel);
        outputText = (TextView) activity.findViewById(R.id.outputText);
        inputText = (TextView) activity.findViewById(R.id.inputText);
        passwordText = (TextView) activity.findViewById(R.id.paswordText);
        aIndex = (CheckBox) activity.findViewById(R.id.aIndexCheckbox);

        actionButton.setOnClickListener(actionListener);
        decodeButton.setOnClickListener(radio_listener);
        encodeButton.setOnClickListener(radio_listener);
    }

    private OnClickListener radio_listener = new OnClickListener() {
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            if (rb.equals(encodeButton)) {
                actionButton.setText(R.string.encode);
                inputLabel.setText(R.string.textToEncode);
            } else {
                actionButton.setText(R.string.decode);
                inputLabel.setText(R.string.textToDecode);
            }

        }
    };

    private OnClickListener actionListener = new OnClickListener() {
        public void onClick(View v) {
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

        String input = inputText.getText().toString().toUpperCase();
        if (input.length() == 0) return;

        String password = passwordText.getText().toString().toUpperCase();
        if (password.length() == 0) return;

        String result = sumWords(input, password, encodeButton.isChecked(),getAIndex());

        outputText.setText(result);
    }

    protected String sumWords(String input, String password, boolean encode, int aIndex) {
        Alphabet alphabet = new Alphabet(aIndex);
        StringBuilder sb = new StringBuilder(input.length());
        int length = Math.min(input.length(), password.length());

        for (int j = 0; j < length; j++) {
           sb.append(sumChars(input, password, encode, alphabet, j));
        }

        return sb.toString();
    }

    protected Character sumChars(String input, String password, boolean encode, Alphabet alphabet, int pos) {
        Integer inputIdx = alphabet.getIndexByChar(input.charAt(pos));
        Integer pwdIdx = alphabet.getIndexByChar(password.charAt(pos));
        if (inputIdx == null || pwdIdx == null)
            return ' ';
        else {
            return alphabet.shiftAsChar(inputIdx, pwdIdx, encode);
        }
    }
}
