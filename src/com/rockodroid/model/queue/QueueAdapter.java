/*
    Rockodroid: Music Player for android
    Copyright (C) 2012  Laura K. Salazar, Roberto R. De la Parra, Juan C. Orozco.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rockodroid.model.queue;

import com.rockodroid.model.vo.MediaItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adaptador para la lista actual de reproducción (Queue)
 * 
 * @author Juan C. Orozco
 */
public class QueueAdapter extends ArrayAdapter<MediaItem> {

	private static final int LAYOUT_QUEUE = 0;

	private final LayoutInflater inflador;

	public QueueAdapter(Context context) {
		super(context, android.R.layout.simple_list_item_1);
		inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Queue cola = Queue.getCola();
		for(MediaItem mi: cola.getElementos()) add(mi);
	}

	/**
	 * Agrega un nuevo elemento al adaptador para ser mostrado en la lista.
	 */
	public void agregar(MediaItem mi) {
		add(mi);
	}

	/**
	 * Obtiene la vista para un elemento MediaItem que se mostrará en
	 * la cola de reproducción.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			holder = new ViewHolder();
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	/* ViewHolder */
	static class ViewHolder {
		TextView qPosicion;
		TextView qTitulo;
		TextView qArtista;
		TextView qDuracion;
	}
}