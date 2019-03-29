package com.example.zhangyujia.asd;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CookbookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CookbookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CookbookFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG="Cookbookfragment";
    private RecipeAdapter mAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mCookbookRecyclerView;
    private OnFragmentInteractionListener mListener;

    DatabaseReference reference;
    public ArrayList<Recipe>  list;
    public CookbookFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CookbookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CookbookFragment newInstance(String param1, String param2) {
        CookbookFragment fragment = new CookbookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        RecipeLab recipeLab = RecipeLab.get(getActivity());

    }
    @Override
    public void onStart(){
        super.onStart();
//
//        RecipeLab recipeLab = RecipeLab.get(getActivity());
//        List<Recipe> recipes=recipeLab.getRecipes();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView");
        View view=inflater.inflate(R.layout.fragment_cookbook,container,false);

        mCookbookRecyclerView = (RecyclerView) view.findViewById(R.id.cookbook_recycler_view);
        mCookbookRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        updateUI();

        list=new ArrayList<Recipe>();
//        for (int i = 0; i < 2; i++) {
//            Recipe MapoTofu = new Recipe("1","Mapo Tofu","Tofu","Pork","",R.drawable.mapotofu_pic);
//            list.add(MapoTofu);
//            Recipe BroccoliShrimp = new Recipe("2","Broccoli Shrimp","Broccoli","Shrimp","",R.drawable.broccolishrimp_pic);
//            list.add(BroccoliShrimp);
//            Recipe KungpaoChicken = new Recipe("3","Kung Pao Chicken","Cucumber","Carrot","",R.drawable.kungpaochicken_pic);
//            list.add(KungpaoChicken);
//            Recipe CurryRice = new Recipe("4","Curry Rice","Chicken","Curry","Potato",R.drawable.curryrice_pic);
//            list.add(CurryRice);
//        }
        reference= FirebaseDatabase.getInstance().getReference().child("recipes");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
                    list.add(recipe);

                }
                mAdapter.notifyDataSetChanged();

                Log.d(TAG,"dataRetrieved");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        Log.d(TAG,"updateUI");
//        RecipeLab recipeLab = RecipeLab.get(getActivity());
//        List<Recipe> recipes=recipeLab.getRecipes();
//
//        while(recipes.isEmpty()){
//            recipes=recipeLab.getRecipes();
//        }
//        mAdapter = new RecipeAdapter(recipes);
//        mCookbookRecyclerView.setAdapter(mAdapter);
        mAdapter = new RecipeAdapter(list);
        mCookbookRecyclerView.setAdapter(mAdapter);
        return view;
    }

//    public Recipe getRecipe(String id){
//        for (Recipe recipe : list){
//            if(recipe.getRecipeId ().equals(id)){
//                return recipe;
//            }
//        }
////        return null;
//    }
//    private void updateUI(){
//        Log.d(TAG,"updateUI");
//        list=new ArrayList<Recipe>();
//        reference= FirebaseDatabase.getInstance().getReference().child("recipes");
//        reference.addValueEventListener(new ValueEventListener() {
//             @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    list.clear();
//                    for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
//                        Recipe recipe=recipeSnapshot.getValue(Recipe.class);
//
//                        list.add(recipe);
//
//                    }
//                    mAdapter = new RecipeAdapter(list);
//                    mCookbookRecyclerView.setAdapter(mAdapter);
//                    Log.d(TAG,"dataRetrieved");
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        RecipeLab recipeLab = RecipeLab.get(getActivity());
//        List<Recipe> recipes=recipeLab.getRecipes();
//        Log.d(TAG,"recipe"+ recipes.isEmpty());
////        mAdapter = new RecipeAdapter(recipes);
//        mCookbookRecyclerView.setAdapter(mAdapter);


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
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
        Log.d(TAG,"onDetach");
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mNameTextView;
        private ImageView mImageView;
        private Recipe mRecipe;
//        final String recipeId=mRecipe.getRecipeId();
//        final String recipeName=mRecipe.getRecipeName();
//        final String ingredient1=mRecipe.getIngredient1();

        private void showDialog(final Recipe mRecipe) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

            LayoutInflater inflater = getLayoutInflater();

            final View dialogView = inflater.inflate(R.layout.update_delete_dialog, null);
            dialogBuilder.setView(dialogView);

            final EditText editTextNewName = (EditText) dialogView.findViewById(R.id.editTextNewName);
            final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);
            final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

            dialogBuilder.setTitle("Editing recipe: " + mRecipe.getRecipeName());

            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();

            buttonUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String newName = editTextNewName.getText().toString().trim();

                    if (!TextUtils.isEmpty(newName)) {
                        updateRecipe(mRecipe, newName);

                        alertDialog.dismiss();
                    } else {
                        editTextNewName.setError("Please enter a new name");
                        return;
                    }
                }
            });

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteRecipe(mRecipe.getRecipeId());

                    alertDialog.dismiss();
                }
            });
        }

        public String imageTranslateUri(int resId) {

            Resources r = getResources();
            Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + r.getResourcePackageName(resId) + "/"
                    + r.getResourceTypeName(resId) + "/"
                    + r.getResourceEntryName(resId));

            return uri.toString();

        }

        private boolean updateRecipe(Recipe mRecipe, String newName) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("recipes").child(mRecipe.getRecipeId());

            Recipe updatedRecipe = new Recipe(mRecipe.getRecipeId(), newName, mRecipe.getIngredient1(), mRecipe.getIngredient2(), mRecipe.getIngredient3(), imageTranslateUri(R.drawable.default_recipe_pic));
            databaseReference.setValue(updatedRecipe);

            Toast.makeText(getActivity(), "Recipe Updated Successfully", Toast.LENGTH_LONG).show();
            return true;
        }


        private void deleteRecipe(String recipeId) {
            DatabaseReference drRecipe = FirebaseDatabase.getInstance().getReference("recipes").child(recipeId);

            drRecipe.removeValue();

            Toast.makeText(getActivity(), "Recipe Deleted Successfully", Toast.LENGTH_LONG).show();
        }

        public RecipeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_recipe,parent,false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.recipe_name);
            mImageView = (ImageView) itemView.findViewById(R.id.recipe_image);



            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    showDialog(mRecipe);
                    return false;
                }
            });
        }

        @Override
        public void onClick(View view){
            Intent intent=RecipeActivity.newIntent(getActivity(),mRecipe.getRecipeId(),mRecipe.getRecipeName(),mRecipe.getIngredient1(),mRecipe.getIngredient2(),mRecipe.getIngredient3(),mRecipe.getImageId());
            startActivity(intent);
        }

        public void bind(Recipe recipe){
            mRecipe = recipe;
            mNameTextView.setText(mRecipe.getRecipeName());
            Picasso.with(getContext()).load(recipe.getImageId()).placeholder(R.drawable.default_recipe_pic).fit().into(mImageView);
//            mImageView.setImageResource(recipe.getImageId());

        }

    }
    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder>{
        private List<Recipe> mRecipes;

        public RecipeAdapter(List<Recipe
                > recipes){
            mRecipes=recipes;

        }
        @Override
        public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new RecipeHolder(layoutInflater,parent);
        }
        @Override
        public void onBindViewHolder(RecipeHolder holder, int position){
            Recipe recipe=mRecipes.get(position);
            holder.bind(recipe);
        }
        @Override
        public int getItemCount(){
            return mRecipes.size();
        }
    }
    @Override
    public void onPause(){
            super.onPause();
            Log.d(TAG,"onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }
}
