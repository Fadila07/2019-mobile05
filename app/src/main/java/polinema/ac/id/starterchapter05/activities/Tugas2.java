package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.BlueFragment;
import polinema.ac.id.starterchapter05.fragments.Dips;
import polinema.ac.id.starterchapter05.fragments.HandstandFragment;
import polinema.ac.id.starterchapter05.fragments.PushUps;

public class Tugas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas2);
    }

    public void handlerHanstand(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if(fragment == null || fragment instanceof Dips || fragment instanceof PushUps) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new HandstandFragment(), "HANDSTAND_FRAGMENT")
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerDips(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if(fragment == null || fragment instanceof HandstandFragment || fragment instanceof PushUps) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new Dips(), "DIPS_FRAGMENT")
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerpush(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if(fragment == null || fragment instanceof HandstandFragment || fragment instanceof Dips) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new PushUps(), "PUSHUPS_FRAGMENT")
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_right, R.anim.exit_from_right)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
