class HomeController < ApplicationController
  def index
  end
  def download_pdf
        send_file(
            "#{Rails.root}/NewResume.pdf",
            filename: "EamonnDaleysResume.pdf",
            type: "application/pdf"
            )
  end
end
