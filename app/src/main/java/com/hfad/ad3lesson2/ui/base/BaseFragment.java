package com.hfad.ad3lesson2.ui.base;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;
import com.hfad.ad3lesson2.R;


public abstract class BaseFragment<VB extends ViewBinding>  extends Fragment {

    protected VB ui;

    protected abstract VB bind();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        ui = bind();
        return ui.getRoot();
    }

    protected void navigate(int id, Bundle bundle){
        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity()
                        .getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        navController.navigate(id, bundle);
    }
}
