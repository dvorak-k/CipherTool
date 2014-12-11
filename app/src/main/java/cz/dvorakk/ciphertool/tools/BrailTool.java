package cz.dvorakk.ciphertool.tools;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import cz.dvorakk.ciphertool.CipherTool;
import cz.dvorakk.ciphertool.R;

public class BrailTool implements CipherTool {

    private ToggleButton topLeft;
    private ToggleButton topRight;
    private ToggleButton middleLeft;
    private ToggleButton middleRight;
    private ToggleButton bottomLeft;
    private ToggleButton bottomRight;
    private Button resetButton;
    private Button nextButton;
    private TextView outputText;
    private TextView fullText;

    private String NA = "N/A";

    @Override
    public int getLayoutId() {
        return R.layout.brail_tool;
    }

    @Override
    public int getTitleId() {
        return R.string.brailToolName;
    }

    public void init(Activity a) {
        topLeft = (ToggleButton) a.findViewById(R.id.LeftTopBrail);
        topRight = (ToggleButton) a.findViewById(R.id.RightTopBrail);
        middleLeft = (ToggleButton) a.findViewById(R.id.LeftMiddleBrail);
        middleRight = (ToggleButton) a.findViewById(R.id.RightMiddleBrail);
        bottomLeft = (ToggleButton) a.findViewById(R.id.LeftBottomBrail);
        bottomRight = (ToggleButton) a.findViewById(R.id.RightBottomBrail);
        resetButton = (Button) a.findViewById(R.id.resetButton);
        nextButton = (Button) a.findViewById(R.id.nextButton);
        outputText = (TextView) a.findViewById(R.id.outputText);
        fullText = (TextView) a.findViewById(R.id.fullText);

        topLeft.setOnClickListener(actionListener);
        topRight.setOnClickListener(actionListener);
        middleLeft.setOnClickListener(actionListener);
        middleRight.setOnClickListener(actionListener);
        bottomLeft.setOnClickListener(actionListener);
        bottomRight.setOnClickListener(actionListener);
        resetButton.setOnClickListener(reset_listener);
        nextButton.setOnClickListener(next_listener);
    }

    private OnClickListener reset_listener = new OnClickListener() {
        public void onClick(View v) {
            topLeft.setChecked(false);
            topRight.setChecked(false);
            middleLeft.setChecked(false);
            middleRight.setChecked(false);
            bottomLeft.setChecked(false);
            bottomRight.setChecked(false);
            compute();
        }
    };

    private OnClickListener next_listener = new OnClickListener() {
        public void onClick(View v) {
            String output = outputText.getText().toString();
            if (!NA.equals(output)) {
                fullText.setText(fullText.getText().toString() + output);
            }
            reset_listener.onClick(v);
        }
    };

    private OnClickListener actionListener = new OnClickListener() {
        public void onClick(View v) {
            compute();
        }
    };

    private void compute() {
        String result;
        if (isSelected(true, false, false, false, false, false))
            result = "A";
        else if (isSelected(true, false, true, false, false, false))
            result = "B";
        else if (isSelected(true, true, false, false, false, false))
            result = "C";
        else if (isSelected(true, true, false, true, false, false))
            result = "D";
        else if (isSelected(true, false, false, true, false, false))
            result = "E";
        else if (isSelected(true, true, true, false, false, false))
            result = "F";
        else if (isSelected(true, true, true, true, false, false))
            result = "G";
        else if (isSelected(true, false, true, true, false, false))
            result = "H";
        else if (isSelected(false, true, true, false, false, false))
            result = "I";
        else if (isSelected(false, true, true, true, false, false))
            result = "J";
        else if (isSelected(true, false, false, false, true, false))
            result = "K";
        else if (isSelected(true, false, true, false, true, false))
            result = "L";
        else if (isSelected(true, true, false, false, true, false))
            result = "M";
        else if (isSelected(true, true, false, true, true, false))
            result = "N";
        else if (isSelected(true, false, false, true, true, false))
            result = "O";
        else if (isSelected(true, true, true, false, true, false))
            result = "P";
        else if (isSelected(true, true, true, true, true, false))
            result = "Q";
        else if (isSelected(true, false, true, true, true, false))
            result = "R";
        else if (isSelected(false, true, true, false, true, false))
            result = "S";
        else if (isSelected(false, true, true, true, true, false))
            result = "T";
        else if (isSelected(true, false, false, false, true, true))
            result = "U";
        else if (isSelected(true, false, true, false, true, true))
            result = "V";
        else if (isSelected(true, false, true, true, true, true))
            result = "W";
        else if (isSelected(true, true, false, false, true, true))
            result = "X";
        else if (isSelected(true, true, false, true, true, true))
            result = "Y";
        else if (isSelected(true, false, false, true, true, true))
            result = "Z";
        else
            result = NA;

        outputText.setText(result);

    }

    private boolean isSelected(Boolean leftTop, Boolean rightTop, Boolean leftMiddle, Boolean rightMiddle,
                               Boolean leftBottom, Boolean rightBottom) {
        return leftTop == topLeft.isChecked() && rightTop == topRight.isChecked()
                && leftMiddle == middleLeft.isChecked() && rightMiddle == middleRight.isChecked()
                && leftBottom == bottomLeft.isChecked() && rightBottom == bottomRight.isChecked();
    }
}
