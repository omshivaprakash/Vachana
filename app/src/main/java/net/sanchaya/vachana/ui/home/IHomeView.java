package net.sanchaya.vachana.ui.home;

import net.sanchaya.vachana.data.model.Vachanaa;
import net.sanchaya.vachana.ui.base.IBaseView;

public interface IHomeView extends IBaseView {

  void updateTodayVachana(Vachanaa mVachanaa);
}
