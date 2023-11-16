package com.example.aplicativo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.aplicativo.R;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroFragment extends Fragment {
    public String Host = "https://vasomonitorado.000webhostapp.com/projeto";

    EditText nome;
    EditText email;
    EditText senha;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroFragment newInstance(String param1, String param2) {
        CadastroFragment fragment = new CadastroFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        nome = view.findViewById(R.id.editTextNome);
        email = view.findViewById(R.id.editTextEmail);
        senha = view.findViewById(R.id.editTextSenha);
        View btnEntrar = view.findViewById(R.id.btn_entrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testIntegra();
            }
        });
        return view;
    }

    private void testIntegra() {
        Ion.getDefault(getContext()).getConscryptMiddleware().enable(false);


        JsonObject json = new JsonObject();
        json.addProperty("usuario", this.nome.toString());
        json.addProperty("senha", this.senha.toString());
        json.addProperty("emailx", this.email.toString());
        Ion.with(CadastroFragment.this)
                .load(Host.concat("/inserirt.php"))
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("erro", e.toString());
                        Log.d("tag", "STATUS RECEIVED");
                    }
                });
    }
}