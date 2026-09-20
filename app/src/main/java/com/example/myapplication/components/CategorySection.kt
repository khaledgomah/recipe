import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.components.CustomChip
import com.example.myapplication.screens.secondary

@Composable
fun CategorySection(modifier: Modifier = Modifier)
{
    var selectedCategory:Int by rememberSaveable { mutableIntStateOf(categories.first().id) }
    Column(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Category",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(secondary)
                )
            ) {
                Text("See All")
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding =PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) {category ->
                CustomChip(selectedCategoryID = selectedCategory, onClick = {
                    selectedCategory = it
                }, category = category)
            }
        }
    }
}

