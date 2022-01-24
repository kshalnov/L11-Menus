package ru.gb.course1.l11_menus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private static final String TAG = "@@@ Fragment";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.popup_button).setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getContext(), v);
            popupMenu.inflate(R.menu.main_menu);
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                Toast.makeText(getContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            popupMenu.show();
        });

        initToolbar();
    }

    private void initToolbar() {
        final Toolbar toolbar = getView().findViewById(R.id.second_toolbar);
        toolbar.setTitle("Второй фрагмент");
        initMenu(toolbar);
    }

    private void initMenu(Toolbar toolbar) {
        final MenuInflater menuInflater = getActivity().getMenuInflater();
        final Menu menu = toolbar.getMenu();
        menuInflater.inflate(R.menu.second_menu, menu);
        menu.findItem(R.id.menu_about).setOnMenuItemClickListener(menuItem -> {
            Toast.makeText(getContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });
    }

}
