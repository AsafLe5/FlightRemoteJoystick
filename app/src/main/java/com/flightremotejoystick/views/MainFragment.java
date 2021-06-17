package com.flightremotejoystick.views;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flightremotejoystick.R;
import com.flightremotejoystick.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    //Initiallize variable
    private FragmentMainBinding binding;
    private View view;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Assign variable
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);
        view = binding.getRoot();

        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from edit text
                String sText = binding.etInput.getText().toString().trim();
                //check condition
                if(!sText.equals("")){
                    //When text is not empty
                    //Set text on text view
                    binding.tvOutput.setText(sText);
                }else{
                    //When text is empty
                    //Display toast
                    Toast.makeText(view.getContext()
                            ,"Please enter text",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //return view
        return view;
    }
}