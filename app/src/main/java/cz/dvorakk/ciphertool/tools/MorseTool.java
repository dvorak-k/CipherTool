package cz.dvorakk.ciphertool.tools;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class MorseTool implements CipherTool {

    private Button dotButton;
    private Button dashButton;
    private Button resetButton;
    private Button nextButton;
    private TextView outputText;
    private TextView normalOutput;
    private TextView switchedOutput;
    private TextView reversedOutput;
    private TextView reversedSwitchedOutput;

    final String NA = "-";

    static final Map<String, String> CODES = new HashMap<String, String>() {
        {
            put(".-", "A");
            put("-...", "B");
            put("-.-.", "C");
            put("-..", "D");
            put(".", "E");
            put("..-.", "F");
            put("--.", "G");
            put("....", "H");
            put("----", "Ch");
            put("..", "I");
            put(".---", "J");
            put("-.-", "K");
            put(".-..", "L");
            put("--", "M");
            put("-.", "N");
            put("---", "O");
            put(".--.", "P");
            put("--.-", "Q");
            put(".-.", "R");
            put("...", "S");
            put("-", "T");
            put("..-", "U");
            put("...-", "V");
            put(".--", "W");
            put("-..-", "X");
            put("-.--", "Y");
            put("--..", "Z");
            put("..--.-", " ");
            put("-----", "0");
            put(".----", "1");
            put("..---", "2");
            put("...--", "3");
            put("....-", "4");
            put(".....", "5");
            put("-....", "6");
            put("--...", "7");
            put("---..", "8");
            put("----.", "9");
            put("--..-", "!");
            put(".-..-", "\"");
            put("-.--.-", "(");
            put("-.--.-", ")");
            put("--..--", ",");
            put("-....-", "-");
            put(".-.-.-", ".");
            put("-..-.", "/");
            put("---...", ":");
            put("-.-.-.", ";");
            put("-...-", "=");
            put("..--..", "?");
            put(".--.-.", "@");
            put(".----.", "'");
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.morse_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.morseToolName;
    }

    public void init(Activity a) {
        dotButton = (Button) a.findViewById(R.id.dotButton);
        dashButton = (Button) a.findViewById(R.id.dashButton);
        resetButton = (Button) a.findViewById(R.id.resetButton);
        nextButton = (Button) a.findViewById(R.id.nextButton);
        outputText = (TextView) a.findViewById(R.id.outputText);
        normalOutput = (TextView) a.findViewById(R.id.normalOutput);
        switchedOutput = (TextView) a.findViewById(R.id.switchedOutput);
        reversedOutput = (TextView) a.findViewById(R.id.reversedOutput);
        reversedSwitchedOutput = (TextView) a.findViewById(R.id.ReversedSwitchedOutput);

        dotButton.setOnClickListener(actionListener);
        dashButton.setOnClickListener(actionListener);
        resetButton.setOnClickListener(reset_listener);
        nextButton.setOnClickListener(next_listener);
    }

    private OnClickListener reset_listener = new OnClickListener() {
        public void onClick(View v) {
            outputText.setText("");
        }
    };

    private OnClickListener next_listener = new OnClickListener() {
        public void onClick(View v) {
            String output = outputText.getText().toString();
            if (output.length() > 0) {
                compute();
                reset_listener.onClick(v);
            }
        }
    };

    private OnClickListener actionListener = new OnClickListener() {
        public void onClick(View v) {
            String output = outputText.getText().toString();
            outputText.setText(output + ((Button) v).getText());
        }
    };

    private void compute() {
        String output = outputText.getText().toString();
        String switched = output.replace('.', 'd').replace('-', '.').replace('d', '-');
        String reversed = new StringBuilder(output).reverse().toString();
        String reversedSwitched = new StringBuilder(switched).reverse().toString();

        appendText(normalOutput, getResult(output));
        appendText(switchedOutput, getResult(switched));
        appendText(reversedOutput, getResult(reversed));
        appendText(reversedSwitchedOutput, getResult(reversedSwitched));
    }

    private String getResult(String code) {
        String result = CODES.get(code);

        if (result == null) {
            result = NA;
        }

        return result;
    }

    private void appendText(TextView t, String text) {
        t.setText(t.getText() + text);
    }
}
