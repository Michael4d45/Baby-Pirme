package com.example.michael.myapplication.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.michael.lib.Prime;
import com.example.michael.myapplication.R;

public class MainFragment extends Fragment
{
	private EditText numInput;
	private Button submit;
	private TextView result;

	private Prime prime = Prime.get();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	boolean clicked = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_main, container, false);

		numInput = (EditText) v.findViewById(R.id.prime_input);
		submit = (Button) v.findViewById(R.id.submit);
		result = (TextView) v.findViewById(R.id.result);


		submit.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				if(clicked)
					return;
				clicked = true;

				String text = numInput.getText().toString();

				result.setText(prime.isArgPrime(text));

				clicked = false;
			}
		});

		return v;
	}

}
