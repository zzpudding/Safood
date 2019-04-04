package com.example.zhangyujia.asd;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RECIPE_ID = "recipe_id";
    private static final String ARG_RECIPE_NAME = "recipe_name";
    private static final String ARG_RECIPE_INGREDIENT1 = "recipe_ingredient1";
    private static final String ARG_RECIPE_INGREDIENT2 = "recipe_ingredient2";
    private static final String ARG_RECIPE_INGREDIENT3 = "recipe_ingredient3";
    private static final String ARG_RECIPE_IMAGE = "recipe_image";
    // TODO: Rename and change types of parameters
    private String mRecipeId;
    private String mRecipeName;
    private String mRecipeIngredient1;
    private String mRecipeIngredient2;
    private String mRecipeIngredient3;
    private String mRecipeImageId;
    private Recipe mRecipe;
    private ImageView mRecipeImage;
    private TextView mRecipeDetail;
    private Button mAddCartBtn;
    private DatabaseHelper mDatabaseHelper;
    private OnFragmentInteractionListener mListener;

//    Bundle args= new Bundle();
//    args.putChar(ARG_MY_OBJECT,myObject);
//    args.putInt(ARG_MY_INT,myInt);
//    args.putCharSequence(ARG_MY_STRING,myString);



    public RecipeFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * /@param param1 Parameter 1.
     * /@param param2 Parameter 2.
     * @return A new instance of fragment RecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeFragment newInstance(String recipeId,String recipeName,String recipeIngredient1,String recipeIngredient2,String recipeIngredient3,String recipeImage) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RECIPE_ID, recipeId);
        args.putString(ARG_RECIPE_NAME, recipeName);
        args.putString(ARG_RECIPE_INGREDIENT1, recipeIngredient1);
        args.putString(ARG_RECIPE_INGREDIENT2, recipeIngredient2);
        args.putString(ARG_RECIPE_INGREDIENT3, recipeIngredient3);
        args.putString(ARG_RECIPE_IMAGE, recipeImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecipeId = getArguments().getString(ARG_RECIPE_ID);
            mRecipeName = getArguments().getString(ARG_RECIPE_NAME);
            mRecipeIngredient1=getArguments().getString(ARG_RECIPE_INGREDIENT1);
            mRecipeIngredient2=getArguments().getString(ARG_RECIPE_INGREDIENT2);
            mRecipeIngredient3=getArguments().getString(ARG_RECIPE_INGREDIENT3);
            mRecipeImageId=getArguments().getString(ARG_RECIPE_IMAGE);
            mRecipe=new Recipe(mRecipeId,mRecipeName,mRecipeIngredient1,mRecipeIngredient2,mRecipeIngredient3,mRecipeImageId);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        mRecipeImage= (ImageView) view.findViewById(R.id.recipe_image);
        Picasso.with(getContext()).load(mRecipeImageId).placeholder(R.drawable.default_recipe_pic).fit().into(mRecipeImage);

//        mRecipeImage.setImageResource(getArguments().getInt(ARG_RECIPE_IMAGE));
        mRecipeDetail=(TextView) view.findViewById(R.id.recipe_detail);
        mRecipeDetail.setMovementMethod(ScrollingMovementMethod.getInstance());
        mRecipeDetail.setText(mRecipeId +mRecipeName+mRecipeIngredient1);
        mAddCartBtn=(Button) view.findViewById(R.id.add_cart);
        mAddCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(mRecipeName,mRecipeIngredient1,mRecipeIngredient2,mRecipeIngredient3,mRecipeImageId);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view){

    }


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


    //Method for generate a list of recipe_id
    public void addToCart(String mRecipeName,String mRecipeIngredient1,String mRecipeIngredient2,String mRecipeIngredient3,String mRecipeImageId) {
        mDatabaseHelper=new DatabaseHelper(getContext());
        mDatabaseHelper.addData(mRecipeName, mRecipeIngredient1, mRecipeIngredient2,mRecipeIngredient3 ,mRecipeImageId );
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("", );



        List <String> mlist=new ArrayList <String>();
        mlist.add(mRecipeId);
//        String s = mlist.get(0);
        Toast.makeText(getActivity(),"Added to cart!",Toast.LENGTH_SHORT).show();
//        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


//    public static RecipeFragment newInstance(String recipeId){
//        Bundle args=new Bundle();
//        args.putCharSequence(ARG_RECIPE_ID,recipeId);
//        RecipeFragment fragment = new RecipeFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

}
