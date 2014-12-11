package cz.dvorakk.ciphertool.tools;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import cz.dvorakk.ciphertool.Alphabet;
import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class CaesarSingleTool implements CipherTool {

    private RadioButton decodeButton;
    private RadioButton encodeButton;
    private Button actionButton;
    private TextView inputLabel;
    private TextView inputText;
    private TextView outputText;
    private TextView shiftText;
    private Button plusButton;
    private Button minusButton;

    @Override
    public int getLayoutId() {
        return R.layout.caesar_single_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.caesarSingleToolName;
    }

    public void init(Activity a) {
        decodeButton = (RadioButton) a.findViewById(R.id.decodeRadio);
        encodeButton = (RadioButton) a.findViewById(R.id.encodeRadio);
        actionButton = (Button) a.findViewById(R.id.decodeButton);
        inputLabel = (TextView) a.findViewById(R.id.inputLabel);
        outputText = (TextView) a.findViewById(R.id.outputText);
        inputText = (TextView) a.findViewById(R.id.inputText);
        shiftText = (TextView) a.findViewById(R.id.editShift);
        plusButton = (Button) a.findViewById(R.id.buttonPlus);
        minusButton = (Button) a.findViewById(R.id.buttonMinus);

        decodeButton.setOnClickListener(radio_listener);
        encodeButton.setOnClickListener(radio_listener);
        actionButton.setOnClickListener(shiftListener);
        plusButton.setOnClickListener(shiftButtonListener);
        minusButton.setOnClickListener(shiftButtonListener);
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

    private OnClickListener shiftListener = new OnClickListener() {
        public void onClick(View v) {
            compute();
        }
    };

    private OnClickListener shiftButtonListener = new OnClickListener() {
        public void onClick(View v) {
            int value;
            try {
                value = Integer.valueOf(shiftText.getText().toString());
            } catch (Exception e) {
                value = 1;
            }

            if (v.equals(plusButton)) {
                shiftText.setText("" + (value + 1));
            } else if (value > 1)
                shiftText.setText("" + (value - 1));
        }
    };

    private void compute() {
        outputText.setText("");

        CharSequence input = inputText.getText().toString().toUpperCase();
        if (input.length() == 0) return;

        if (shiftText.getText().length() == 0) return;
        int shift = Integer.valueOf(shiftText.getText().toString());

        StringBuilder sb = new StringBuilder(input.length());
        shiftInput(input, shift,encodeButton.isChecked(), sb);
        outputText.setText(sb.toString());
    }

    public static void shiftInput(CharSequence input, int shift, boolean encode, StringBuilder sb) {
        Alphabet alphabet = new Alphabet(0);

        for (int j = 0; j < input.length(); j++) {
            Integer charIndex = alphabet.getIndexByChar(input.charAt(j));
            if (charIndex == null)
                sb.append(input.charAt(j));
            else {
                sb.append(alphabet.shiftAsChar(charIndex, shift, encode));
            }
        }
    }
}
