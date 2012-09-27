package org.solovyev.android.calculator;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;

/**
 * User: serso
 * Date: 9/26/12
 * Time: 10:14 PM
 */
public class CalculatorFragmentHelperImpl extends AbstractCalculatorHelper implements CalculatorFragmentHelper {

    @Override
    public boolean isPane(@NotNull Fragment fragment) {
        return fragment.getActivity() instanceof CalculatorActivity;
    }

    public void setPaneTitle(@NotNull Fragment fragment, int titleResId) {
        final TextView fragmentTitle = (TextView) fragment.getView().findViewById(R.id.fragmentTitle);
        if (fragmentTitle != null) {
            if (!isPane(fragment)) {
                fragmentTitle.setVisibility(View.GONE);
            } else {
                fragmentTitle.setText(fragment.getString(titleResId).toUpperCase());
            }
        }
    }

    @Override
    public void processButtons(@NotNull Fragment fragment, @NotNull View root) {
        super.processButtons(fragment.getActivity(), root);
    }

    @Override
    public void onCreate(@NotNull Fragment fragment) {
        super.onCreate(fragment.getActivity());
    }

    @Override
    public void onDestroy(@NotNull Fragment fragment) {
        super.onDestroy(fragment.getActivity());
    }
}