package com.ict.app.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.ict.app.R;
import com.ict.app.constant.Ict;
import com.ict.app.pojo.StudentSubject;

import static com.facebook.share.R.id.image;

public class RegistrationAdapter extends ArrayAdapter<StudentSubject> {
	
	private Context context;
    private List<StudentSubject> students;
	private LruCache<Integer, Bitmap> imageCache;
	private RequestQueue queue;

	private Typeface font = null;

	public RegistrationAdapter(Context context, int resource, List<StudentSubject> students) {
		super(context, resource, students);
        this.context = context;
        this.students = students;


		final int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
		final int maxSize = maxMemory / 8;

		imageCache = new LruCache<>(maxSize);

		queue = Volley.newRequestQueue(context);

		font = Typeface.createFromAsset(context.getAssets(), "font/PTN57F-webfont.ttf");

	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.subject_list, parent, false);
		
		final StudentSubject registration = students.get(position);
		
		TextView textViewName = (TextView) view.findViewById(R.id.textViewSubjCode);
		textViewName.setTypeface(font);
		TextView textViewDiploma = (TextView) view.findViewById(R.id.textViewSubjName);
		textViewDiploma.setTypeface(font);
		TextView textViewDept = (TextView) view.findViewById(R.id.textViewSubjRegDate);
		textViewDept.setTypeface(font);

		//Display order information
		textViewName.setText(registration.getSubjCode() + ":\n" + registration.getSubjName());
		textViewDiploma.setText(registration.getDipName());
	    textViewDept.setText(registration.getDepartment());

     // get the bitmap from cache memory
		Bitmap bitmap = imageCache.get(registration.getId());
		final ImageView image = (ImageView) view.findViewById(R.id.imageViewStatus);

		if (bitmap != null) {
			image.setImageBitmap(bitmap);
		} else {
			ImageRequest imageRequest = new ImageRequest(Ict.IMAGE_URL + registration.getStatusUrl(),
					new Response.Listener<Bitmap>() {

						@Override
						public void onResponse(Bitmap arg0) {
							image.setImageBitmap(arg0);
							imageCache.put(registration.getId(), arg0);
						}
					},
					20,
					20,
					Bitmap.Config.ARGB_8888,
					new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError err) {
							Log.d("Error", err.getMessage());
						}
					});
			queue.add(imageRequest);
		}

		return view; 
	}
}
