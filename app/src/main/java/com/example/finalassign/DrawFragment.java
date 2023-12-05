package com.example.finalassign;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class DrawFragment extends Fragment {
    private Paint paint;
    private DrawingView drawingView;
    private List<Path> paths;
    private List<Integer> pathColors;
    private int currentColor;
    private boolean isDrawingEnabled = true;

    @Override
    public void onPause() {
        clearCanvas();
        super.onPause();
        isDrawingEnabled = false;
    }

    @Override
    public void onStop() {
        clearCanvas();
        super.onStop();
        isDrawingEnabled = false;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isDrawingEnabled = !hidden;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearCanvasT();
    }

    private void clearCanvasT() {
        paths.clear();
        pathColors.clear();
        if (drawingView != null) {
            drawingView.release();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        drawingView = new DrawingView(getActivity());
        container.addView(drawingView);

        paths = new ArrayList<>();
        pathColors = new ArrayList<>();
        currentColor = Color.BLACK;

        paint = new Paint();
        paint.setColor(currentColor);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        Button redButton = view.findViewById(R.id.button_red);
        redButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        Button blueButton = view.findViewById(R.id.button_blue);
        blueButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
        ImageButton clearButton = view.findViewById(R.id.button_clear);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = Color.RED;
                paint.setColor(currentColor);
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = Color.BLUE;
                paint.setColor(currentColor);
            }
        });

        return view;
    }

    private void clearCanvas() {
        paths.clear();
        pathColors.clear();
        drawingView.invalidate();
    }

    private class DrawingView extends View {
        private Path currentPath;

        public void release() {
            currentPath = null;
        }
        public DrawingView(Context context) {
            super(context);
            currentPath = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < paths.size(); i++) {
                paint.setColor(pathColors.get(i));
                canvas.drawPath(paths.get(i), paint);
            }
            if (currentPath != null) {
                canvas.drawPath(currentPath, paint);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (!isDrawingEnabled) {
                return false;
            }

            float touchX = event.getX();
            float touchY = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    currentPath = new Path();
                    currentPath.moveTo(touchX, touchY);
                    pathColors.add(currentColor);
                    paths.add(currentPath);
                    break;
                case MotionEvent.ACTION_MOVE:
                    currentPath.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:
                    currentPath = null;
                    break;
            }
            invalidate();
            return true;
        }
    }
}
