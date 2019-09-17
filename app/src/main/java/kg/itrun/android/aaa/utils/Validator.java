package kg.itrun.android.aaa.utils;

import android.content.Context;
import android.widget.EditText;

import androidx.annotation.StringRes;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.ValidationException;

public class Validator {

    private Context context;

    public Validator(Context context) {
        this.context = context;
    }

    public void validate(EditText editText, String regex, @StringRes int res)
            throws ValidationException {
        validate(editText.getText().toString(), regex, context.getString(res), editText.getId());
    }

    public void validate(EditText editText, String regex, String errorMessage)
            throws ValidationException {
        validate(editText.getText().toString(), regex, errorMessage, editText.getId());
    }

    public void validateEquals(EditText editText1, EditText editText2, @StringRes int string)
            throws ValidationException {
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        if (!str1.equals(str2))// str1 = " " str2 = "a"
            throw new ValidationException(editText2.getId(), context.getString(string));
        if (str1.isEmpty())
            throw new ValidationException(editText2.getId(), context.getString(R.string.cannot_be_empty));
    }

    /**
     * Validates EditText fields
     *
     * @param text         - string that must be validate
     * @param regex        - regular expression
     * @param errorMessage - error message if not valid
     * @param viewId       - view id to identify exception
     * @throws ValidationException
     */
    public void validate(String text, String regex, String errorMessage, int viewId)
            throws ValidationException {
        if (text == null || text.isEmpty())
            throw new ValidationException(viewId, errorMessage);

        if (regex != null && !text.matches(regex))
            throw new ValidationException(viewId, context.getString(R.string.wrong_format));
    }
}
