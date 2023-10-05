package vn.edu.usth.imdbclient.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.imdbclient.R;

public class Featured extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured, container, false);
        ArrayList<Feat> employelist
                = Constant.getEmployeeData();

        // Assign employeelist to ItemAdapter
        FeaturedAdapter itemAdapter = new FeaturedAdapter(employelist);

        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = v.findViewById(R.id.recycleView);

        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        return v;
    }

    public static Featured newInstance(String param1,
                                       String param2) {
        Featured fragment = new Featured();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}
