package cz.dvorakk.ciphertool;

import android.app.Activity;

/**
 * Represents one of the cipher tools,
 * encapsulates both the screen and related logic
 */
public interface CipherTool {

    /**
     * Initializes the internal state
     * @param activity the activity that runs this tool
     */
    public void init(Activity activity);

    /**
     * Returns the id of the layout that belongs to this cipher tool
     * @return
     */
    public int getLayoutId();

    /**
     * Returns the resource id with the name of this cipher tool
     * @return
     */
    public int getTitleId();
}