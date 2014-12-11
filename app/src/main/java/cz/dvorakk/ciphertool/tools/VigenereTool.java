package cz.dvorakk.ciphertool.tools;

import cz.dvorakk.ciphertool.R;

public class VigenereTool extends WordSumTool {

    @Override
    public int getTitleId() {
        return R.string.vigenereToolName;
    }

    @Override
    protected void compute() {
        outputText.setText("");

        String input = inputText.getText().toString().toUpperCase();
        if (input.length() == 0) return;

        String password = passwordText.getText().toString().toUpperCase();
        if (password.length() == 0) return;

        int length = input.length();
        while (password.length() < length)
            password = password.concat(password);

        String result = sumWords(input, password, encodeButton.isChecked(), getAIndex());

        outputText.setText(result);
    }
}
