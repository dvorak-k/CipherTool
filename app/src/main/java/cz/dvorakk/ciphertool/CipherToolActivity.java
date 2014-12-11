package cz.dvorakk.ciphertool;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import cz.dvorakk.ciphertool.tools.AutoclaveTool;
import cz.dvorakk.ciphertool.tools.BrailTool;
import cz.dvorakk.ciphertool.tools.CaesarSingleTool;
import cz.dvorakk.ciphertool.tools.CaesarTool;
import cz.dvorakk.ciphertool.tools.LetterNumberSumTool;
import cz.dvorakk.ciphertool.tools.LetterSumTool;
import cz.dvorakk.ciphertool.tools.MorseTool;
import cz.dvorakk.ciphertool.tools.NumberLetterSumTool;
import cz.dvorakk.ciphertool.tools.NumberSumTool;
import cz.dvorakk.ciphertool.tools.VigenereTool;
import cz.dvorakk.ciphertool.tools.WordSumTool;

public class CipherToolActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cipher_tool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        createView(item.getItemId());
        return true;
    }

    private void createView(int menuId) {
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup parent = (ViewGroup) findViewById(R.id.toolPlace);
        parent.removeAllViews();

        CipherTool tool;

        if (menuId == R.id.caesarToolMenu) {
            tool = new CaesarTool();
        } else if (menuId == R.id.caesarSingleToolMenu) {
            tool = new CaesarSingleTool();
        } else if (menuId == R.id.wordSumToolMenu) {
            tool = new WordSumTool();
        } else if (menuId == R.id.vigenereToolMenu) {
            tool = new VigenereTool();
        } else if (menuId == R.id.autoclaveToolMenu) {
            tool = new AutoclaveTool();
        } else if (menuId == R.id.letterSumToolMenu) {
            tool = new LetterSumTool();
        } else if (menuId == R.id.letterNumberSumToolMenu) {
            tool = new LetterNumberSumTool();
        } else if (menuId == R.id.numberSumToolMenu) {
            tool = new NumberSumTool();
        } else if (menuId == R.id.numberLetterSumToolMenu) {
            tool = new NumberLetterSumTool();
        } else if (menuId == R.id.brailToolMenu) {
            tool = new BrailTool();
        } else if (menuId == R.id.morseToolMenu) {
            tool = new MorseTool();
        } else {
            throw new RuntimeException("Unsupported menu item");
        }

        inflater.inflate(tool.getLayoutId(), parent);
        tool.init(this);

        Resources res = getResources();
        String title = String.format("%s - %s", res.getString(R.string.appName), res.getString(tool.getTitleId()));
        setTitle(title);
    }

}