package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.BlueFragment;
import polinema.ac.id.starterchapter05.fragments.RedFragment;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }

    public void handlerClickLoadRedFragment(View view) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
////        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right);
////        fragmentTransaction.replace(R.id.dynamic_fragment_placeholder,new RedFragment(), "RED_FRAGMENT");
////        fragmentTransaction.add(R.id.dynamic_fragment_placeholder,new RedFragment());
//
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.dynamic_fragment_placeholder);
        if(fragment == null || fragment instanceof BlueFragment){
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.dynamic_fragment_placeholder, new RedFragment(), "RED_FRAGMENT")
            .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right)
                .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerClickLoadBlueFragment(View view) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right);
//        fragmentTransaction.replace(R.id.dynamic_fragment_placeholder,new BlueFragment(), "BLUE_FRAGMENT");
////        fragmentTransaction.add(R.id.dynamic_fragment_placeholder,new BlueFragment());
////        fragmentTransaction.remove(new BlueFragment());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("BLUE_FRAGMENT");
        if(fragment == null || fragment instanceof RedFragment){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dynamic_fragment_placeholder, new BlueFragment(), "BLUE_FRAGMENT")
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
