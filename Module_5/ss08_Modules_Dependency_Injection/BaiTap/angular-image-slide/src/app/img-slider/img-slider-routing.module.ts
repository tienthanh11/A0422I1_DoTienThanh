import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImgSliderComponent} from "./img-slider.component";
import {ImgSlideComponent} from "./img-slide/img-slide.component";


const routes: Routes = [
  {path: 'slider', component: ImgSliderComponent},
  {path: 'slide', component: ImgSlideComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImgSliderRoutingModule { }
