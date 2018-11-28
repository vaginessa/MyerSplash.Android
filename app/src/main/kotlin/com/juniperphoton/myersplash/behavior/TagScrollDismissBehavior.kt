package com.juniperphoton.myersplash.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TagScrollDismissBehavior(context: Context?, attrs: AttributeSet?
) : CoordinatorLayout.Behavior<View>(context, attrs) {
    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return dependency is FloatingActionButton
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout,
                                        child: View,
                                        dependency: View): Boolean {
        if ((dependency as FloatingActionButton).isShown) {
            child.animate().alpha(0f).start()
        } else {
            child.animate().alpha(1f).start()
        }
        return false
    }
}