import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingGuestComponent} from './site/pages/landing/landing-guest/landing-guest.component';

const routes: Routes = [
  { path: 'auth', loadChildren: () => import('./site/pages/auth/auth.module').then(m => m.AuthModule) },
  { path: 'decks', loadChildren: () => import('./site/pages/decks/decks.module').then(m => m.DecksModule) },
  { path: 'cards', loadChildren: () => import('./site/pages/cards/cards.module').then(m => m.CardsModule) },
  { path: 'learn', loadChildren: () => import('./site/pages/learning/learning.module').then(m => m.LearningModule) },
  { path: '', component: LandingGuestComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
