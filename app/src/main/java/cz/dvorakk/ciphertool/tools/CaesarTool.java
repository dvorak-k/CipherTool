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

public class CaesarTool implements CipherTool {

    private RadioButton decodeButton;
    private RadioButton encodeButton;
    private Button actionButton;
    private TextView inputLabel;
    private TextView inputText;
    private TextView outputText;

    @Override
    public int getLayoutId() {
        return R.layout.caesar_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.caesarToolName;
    }

    @Override
    public void init(Activity a) {
        decodeButton = (RadioButton) a.findViewById(R.id.decodeRadio);
        encodeButton = (RadioButton) a.findViewById(R.id.encodeRadio);
        actionButton = (Button) a.findViewById(R.id.decodeButton);
        inputLabel = (TextView) a.findViewById(R.id.inputLabel);
        outputText = (TextView) a.findViewById(R.id.outputText);
        inputText = (TextView) a.findViewById(R.id.inputText);

        decodeButton.setOnClickListener(radio_listener);
        encodeButton.setOnClickListener(radio_listener);
        actionButton.setOnClickListener(actionListener);
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

    private void compute() {
        outputText.setText("");

        CharSequence input = inputText.getText().toString().toUpperCase();
        if (input.length() == 0) return;

        Alphabet alphabet = new Alphabet(0);
        int alphabetLength = alphabet.getLength();

        StringBuilder sb = new StringBuilder((input.length() + 3) * alphabetLength);

        for (int i = 1; i <= alphabetLength; i++) {
            appendListingLinePrefix(sb, i);
            CaesarSingleTool.shiftInput(input, i,encodeButton.isChecked(),sb);
            sb.append("\n");
        }
        outputText.setText(sb.toString());
    }

    private void appendListingLinePrefix(StringBuilder sb, int i) {
        if (i < 10) sb.append(" ");
        if (decodeButton.isChecked()) sb.append("-");
        sb.append(i).append(": ");
    }
}
