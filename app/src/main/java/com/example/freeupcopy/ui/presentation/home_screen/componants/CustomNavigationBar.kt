package com.example.freeupcopy.ui.presentation.home_screen.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.freeupcopy.R
import com.example.freeupcopy.ui.theme.FreeUpCopyTheme

@Composable
fun CustomNavigationBar(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        CustomBottomBar(
            windowInsets = windowInsets
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(y = (-30).dp)
                .shadow(6.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable(
                    onClick = { }
                )
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.rounded_sell_24),
                contentDescription = "add",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(40.dp)
            )
        }
    }

}

@Composable
fun CustomNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    selectedIcon: ImageVector
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(60.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(28.dp),
            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            imageVector = if(selected) selectedIcon else icon,
            contentDescription = null
        )
    }
}

@Composable
fun CustomNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    icon: Painter,
    selectedIcon: Painter
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(60.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(28.dp),
            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            painter = if(selected) selectedIcon else icon,
            contentDescription = null
        )
    }
}

@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .windowInsetsPadding(windowInsets)
            .defaultMinSize(minHeight = 70.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomNavigationBarItem(
            selected = false,
            onClick = { },
            icon = painterResource(id = R.drawable.ic_home),
            selectedIcon = painterResource(id = R.drawable.ic_home_selected)
        )

        CustomNavigationBarItem(
            selected = true,
            onClick = { },
            icon = painterResource(id = R.drawable.ic_favorite),
            selectedIcon = painterResource(id = R.drawable.ic_favorite_selected)
        )

        Spacer(modifier = Modifier.size(80.dp)) // Leave space for the FAB

        CustomNavigationBarItem(
            selected = false,
            onClick = { },
            icon = painterResource(id = R.drawable.ic_message),
            selectedIcon = painterResource(id = R.drawable.ic_message_selected)
        )

        CustomNavigationBarItem(
            selected = false,
            onClick = { },
            icon = painterResource(id = R.drawable.ic_person),
            selectedIcon = painterResource(id = R.drawable.ic_person_selected)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomNavigationPreview() {
    FreeUpCopyTheme {
        CustomNavigationBar()
    }
}