import android.content.Context
import androidx.room.*
import com.example.zoohelper.Animal
import com.example.zoohelper.Dao

@Database(entities = [Animal::class], version = 1)
abstract class MainDB(): RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        fun getDB(context: Context): MainDB{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "HistoryTransaction"
            ).build()
        }
    }
}