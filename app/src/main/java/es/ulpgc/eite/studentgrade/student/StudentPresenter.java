package es.ulpgc.eite.studentgrade.student;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentPresenter implements StudentContract.Presenter {

  public static String TAG = "StudentGrade.StudentPresenter";

  private WeakReference<StudentContract.View> view;
  private StudentState state;
  private StudentContract.Model model;
  private AppMediator mediator;

  public StudentPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getStudentState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {
      model.onDataFromNextScreen(savedState.data);
      state.data=model.getStoredData();
      view.get().onDataUpdated(state);
      // TODO: include code here if is necessary

    }
    // TODO: include code here if is necessary

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onOutstandingGradeBtnClicked() {

    // TODO: include code here if is necessary
    StudentToGradeState state = new StudentToGradeState();
    state.data = "9,10";
    mediator.setNextStudentScreenState(state);
    view.get().navigateToNextScreen();

  }

  @Override
  public void onMentionGradeBtnClicked() {

    // TODO: include code here if is necessary
    StudentToGradeState state = new StudentToGradeState();
    state.data = "7,8";
    mediator.setNextStudentScreenState(state);
    view.get().navigateToNextScreen();

  }

  @Override
  public void onPassGradeBtnClicked() {

    // TODO: include code here if is necessary
    StudentToGradeState state = new StudentToGradeState();
    state.data = "5,6";
    mediator.setNextStudentScreenState(state);
    view.get().navigateToNextScreen();

  }

  private GradeToStudentState getStateFromNextScreen() {
    return mediator.getNextStudentScreenState();
  }

  private void passStateToNextScreen(StudentToGradeState state) {
    mediator.setNextStudentScreenState(state);
  }


  @Override
  public void injectView(WeakReference<StudentContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StudentContract.Model model) {
    this.model = model;
  }

}
