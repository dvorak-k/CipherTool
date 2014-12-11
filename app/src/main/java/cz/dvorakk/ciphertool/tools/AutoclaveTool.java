package cz.dvorakk.ciphertool.tools;

import cz.dvorakk.ciphertool.Alphabet;
import cz.dvorakk.ciphertool.R;

public class AutoclaveTool extends WordSumTool {

    @Override
    public int getTitleId() {
        return R.string.autoclaveToolName;
    }

    @Override
    protected void compute() {
        outputText.setText("");

        int aIndex = getAIndex();
        Alphabet alphabet = new Alphabet(aIndex);
        String input = alphabet.removeUnknownChars(inputText.getText().toString().toUpperCase());
        inputText.setText(input);
        if (input.length() == 0) return;

        String password = alphabet.removeUnknownChars(passwordText.getText().toString().toUpperCase());
        passwordText.setText(password);
        if (password.length() == 0) return;

        String result = autoclaveWords(input, password, alphabet, encodeButton.isChecked(), aIndex);

        outputText.setText(result);
    }

    protected String autoclaveWords(String input, String password, Alphabet alphabet, boolean encode, int aIndex) {
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);

        if (encode) {
            password = password.concat(input);
        }

        for (int j = 0; j < length; j++) {
            Character encodedChar = sumChars(input, password, encode, alphabet, j);
            sb.append(encodedChar);
            if (!encode) {
                password = password.concat("" + encodedChar);
            }
        }

        return sb.toString();
    }
}
