Rails.application.routes.draw do

  root to: 'visitors#index'
  resources :homes
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  get "home/download_pdf"
end
