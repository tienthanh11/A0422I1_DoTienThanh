import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ImgSliderRoutingModule} from './img-slider-routing.module';
import {ImgSliderComponent} from './img-slider.component';
import {ImgSlideComponent} from './img-slide/img-slide.component';
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [ImgSliderComponent, ImgSlideComponent],
  exports: [
    ImgSlideComponent,
    ImgSliderComponent
  ],
  imports: [
    CommonModule,
    ImgSliderRoutingModule,
    NgxPaginationModule
  ]
})
export class ImgSliderModule {
}
