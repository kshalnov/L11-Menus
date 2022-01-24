package ru.gb.course1.l11_menus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private static final String TAG = "@@@ Fragment";
    private int layoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        setHasOptionsMenu(true);
    }

    private void setContentView(int layoutId) {
        this.layoutId = layoutId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]");
        super.onViewCreated(view, savedInstanceState);
        final Toolbar toolbar = view.findViewById(R.id.first_toolbar);

        final MenuInflater menuInflater = getActivity().getMenuInflater();
        final Menu menu = toolbar.getMenu();

        onCreateOptionsMenu(menu, menuInflater);
        menu.findItem(R.id.menu_settings).setOnMenuItemClickListener(this::onOptionsItemSelected);
        menu.findItem(R.id.menu_android).setOnMenuItemClickListener(this::onOptionsItemSelected);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        Log.d(TAG, "onCreateOptionsMenu() called with: menu = [" + menu + "], inflater = [" + inflater + "]");
        inflater.inflate(R.menu.first_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected() called with: item = [" + item + "]");
        Toast.makeText(getActivity(), "Fragment " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.menu_settings:
            case R.id.menu_android:
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
