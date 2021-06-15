package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.BasicDragPage;
import pages2.DragOnCheckPage;
import pages2.DragPage;
import pages2.DraggableWithSectionPage;
import pages2.GridDragPage;
import pages2.LongPressDragPage;
import pages2.MinimunDragPage;
import pages2.StaggeredGridDragPage;

public class DraggableTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

	@Test(priority = 1)
	public void verifyMinDrag() {

		DragPage drag = new DragPage(driver);
		drag.selectDragMin();
		MinimunDragPage basic = new MinimunDragPage(driver);
		basic.dragItems();
	}

	@Test(priority = 2)
	public void verifyBasicDrag() {

		DragPage drag = new DragPage(driver);
		drag.selectDragBasic();
		BasicDragPage min = new BasicDragPage(driver);
		min.dragItems();
	}

	@Test(priority = 3)
	public void verifyLongPressSwipe() {

		DragPage drag = new DragPage(driver);
		drag.selectDragLongPress();
		LongPressDragPage min = new LongPressDragPage(driver);
		min.dragItems();
	}

	@Test(priority = 4)
	public void verifyDragInSections() {

		DragPage drag = new DragPage(driver);
		drag.draggableWithSection();
		DraggableWithSectionPage sec = new DraggableWithSectionPage(driver);
		sec.dragItems();
	}

	@Test(priority = 5)
	public void verifyDragOnCheck() {

		DragPage drag = new DragPage(driver);
		drag.dragOnCheckAndDrop();
		DragOnCheckPage check = new DragOnCheckPage(driver);
		check.dragItems();
	}

	@Test(priority = 6)
	public void verifyGridDrag() {

		DragPage drag = new DragPage(driver);
		drag.gridLayout();
		GridDragPage grid = new GridDragPage(driver);
		grid.dragItems();
	}

	@Test(priority = 7)
	public void verifyStaggeredGridDrag() {

		DragPage drag = new DragPage(driver);
		drag.staggeredGridLayout();
		StaggeredGridDragPage stag = new StaggeredGridDragPage(driver);
		stag.dragItems();
	}
}