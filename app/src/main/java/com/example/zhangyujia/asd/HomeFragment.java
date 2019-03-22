package com.example.zhangyujia.asd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.view.View.OnClickListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG="homefragment";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button addButton;
    private Button cbButton;

    private OnFragmentInteractionListener mListener;
//    private OnButtonClickListener1 onButtonClickListener1 ;
//    private OnButtonClickListener2 onButtonClickListener2 ;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        addButton =(Button)view.findViewById(R.id.add_recipe_btn);
        cbButton  = (Button)view.findViewById(R.id.cookbook_btn);
        Log.d(TAG,"Button wired");
        addButton.setOnClickListener(this);

        cbButton.setOnClickListener(this);
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG,"clicked add");
//                FragmentManager fm = getActivity().getSupportFragmentManager();
//
//                fm.beginTransaction().replace(R.id.fragment_container,new CookbookFragment())
//                        .commit();
//
////                    Intent intent= new Intent(TagActivity.this, CookbookActivity.class);
////                startActivity(intent);
//                }
////                Intent intent=new Intent(TagActivity.this, AddRecipeActivity.class);
////                startActivity(intent);
//
//        });
        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
//        if (getActivity() instanceof OnButtonClickListener1)
//            onButtonClickListener1 = (OnButtonClickListener1) getActivity();
//        if (getActivity() instanceof OnButtonClickListener1)
//            onButtonClickListener2 = (OnButtonClickListener2) getActivity();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_recipe_btn:
                Log.d(TAG,"clicked add");
                Intent intent1=new Intent(getActivity(), AddRecipeActivity.class);
                startActivity(intent1);
//                if(onButtonClickListener1 != null)
//                {
//                    onButtonClickListener1.onButtonClick1();
//                }
                break;
            case R.id.cookbook_btn:
                Log.d(TAG,"clicked cookbook");
                Intent intent2=new Intent(getActivity(), CookbookActivity.class);
                startActivity(intent2);
//                if(onButtonClickListener2 != null)
//                {
//                    onButtonClickListener2.onButtonClick2();
//                }
                break;
                default:break;
        }
    }
//



        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
//    public interface OnButtonClickListener1
//        {
//            void onButtonClick1();
//        }
//    public void setOnButtonClickListener1(OnButtonClickListener1 onButtonClickListener1)
//    {
//        this.onButtonClickListener1 = onButtonClickListener1;
//    }
//
//    public interface OnButtonClickListener2
//    {
//        void onButtonClick2();
//    }
//    public void setOnButtonClickListener2(OnButtonClickListener2 onButtonClickListener2)
//    {
//        this.onButtonClickListener2 = onButtonClickListener2;
//    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
//    private Button addButton;
//    private Button cbButton;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        addButton = findViewById(R.id.add_recipe_button);
//        cbButton  = findViewById(R.id.cookbook_button);
//        cbButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(TagActivity.this, CookbookActivity.class);
//                startActivity(intent);
//            }
//        });
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(TagActivity.this, AddRecipeActivity.class);
//                startActivity(intent);
//            }
//        });
//    }