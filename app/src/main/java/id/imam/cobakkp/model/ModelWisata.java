package id.imam.cobakkp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelWisata {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_wisata")
    @Expose
    private String namaWisata;
    @SerializedName("deskripsi_wisata")
    @Expose
    private String deskripsiWisata;
    @SerializedName("harga_wisata")
    @Expose
    private String hargaWisata;
    @SerializedName("tempat_wisata")
    @Expose
    private String tempatWisata;
    @SerializedName("keterangan_wisata")
    @Expose
    private String keteranganWisata;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("gambar_wisata")
    @Expose
    private Formats.GambarWisata gambarWisata;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getDeskripsiWisata() {
        return deskripsiWisata;
    }

    public void setDeskripsiWisata(String deskripsiWisata) {
        this.deskripsiWisata = deskripsiWisata;
    }

    public String getHargaWisata() {
        return hargaWisata;
    }

    public void setHargaWisata(String hargaWisata) {
        this.hargaWisata = hargaWisata;
    }

    public String getTempatWisata() {
        return tempatWisata;
    }

    public void setTempatWisata(String tempatWisata) {
        this.tempatWisata = tempatWisata;
    }

    public String getKeteranganWisata() {
        return keteranganWisata;
    }

    public void setKeteranganWisata(String keteranganWisata) {
        this.keteranganWisata = keteranganWisata;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Formats.GambarWisata getGambarWisata() {
        return gambarWisata;
    }

    public void setGambarWisata(Formats.GambarWisata gambarWisata) {
        this.gambarWisata = gambarWisata;
    }



    public class Formats {

        @SerializedName("thumbnail")
        @Expose
        private GambarWisata.Medium.Small.Thumbnail thumbnail;
        @SerializedName("medium")
        @Expose
        private GambarWisata.Medium medium;
        @SerializedName("small")
        @Expose
        private GambarWisata.Medium.Small small;

        public GambarWisata.Medium.Small.Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(GambarWisata.Medium.Small.Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public GambarWisata.Medium getMedium() {
            return medium;
        }

        public void setMedium(GambarWisata.Medium medium) {
            this.medium = medium;
        }

        public GambarWisata.Medium.Small getSmall() {
            return small;
        }

        public void setSmall(GambarWisata.Medium.Small small) {
            this.small = small;
        }


        public class GambarWisata {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("alternativeText")
            @Expose
            private String alternativeText;
            @SerializedName("caption")
            @Expose
            private String caption;
            @SerializedName("width")
            @Expose
            private Integer width;
            @SerializedName("height")
            @Expose
            private Integer height;
            @SerializedName("formats")
            @Expose
            private Formats formats;
            @SerializedName("hash")
            @Expose
            private String hash;
            @SerializedName("ext")
            @Expose
            private String ext;
            @SerializedName("mime")
            @Expose
            private String mime;
            @SerializedName("size")
            @Expose
            private Double size;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("previewUrl")
            @Expose
            private Object previewUrl;
            @SerializedName("provider")
            @Expose
            private String provider;
            @SerializedName("provider_metadata")
            @Expose
            private Object providerMetadata;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlternativeText() {
                return alternativeText;
            }

            public void setAlternativeText(String alternativeText) {
                this.alternativeText = alternativeText;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public Formats getFormats() {
                return formats;
            }

            public void setFormats(Formats formats) {
                this.formats = formats;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public String getExt() {
                return ext;
            }

            public void setExt(String ext) {
                this.ext = ext;
            }

            public String getMime() {
                return mime;
            }

            public void setMime(String mime) {
                this.mime = mime;
            }

            public Double getSize() {
                return size;
            }

            public void setSize(Double size) {
                this.size = size;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object getPreviewUrl() {
                return previewUrl;
            }

            public void setPreviewUrl(Object previewUrl) {
                this.previewUrl = previewUrl;
            }

            public String getProvider() {
                return provider;
            }

            public void setProvider(String provider) {
                this.provider = provider;
            }

            public Object getProviderMetadata() {
                return providerMetadata;
            }

            public void setProviderMetadata(Object providerMetadata) {
                this.providerMetadata = providerMetadata;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }


            public class Medium {

                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("hash")
                @Expose
                private String hash;
                @SerializedName("ext")
                @Expose
                private String ext;
                @SerializedName("mime")
                @Expose
                private String mime;
                @SerializedName("width")
                @Expose
                private Integer width;
                @SerializedName("height")
                @Expose
                private Integer height;
                @SerializedName("size")
                @Expose
                private Double size;
                @SerializedName("path")
                @Expose
                private Object path;
                @SerializedName("url")
                @Expose
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public String getExt() {
                    return ext;
                }

                public void setExt(String ext) {
                    this.ext = ext;
                }

                public String getMime() {
                    return mime;
                }

                public void setMime(String mime) {
                    this.mime = mime;
                }

                public Integer getWidth() {
                    return width;
                }

                public void setWidth(Integer width) {
                    this.width = width;
                }

                public Integer getHeight() {
                    return height;
                }

                public void setHeight(Integer height) {
                    this.height = height;
                }

                public Double getSize() {
                    return size;
                }

                public void setSize(Double size) {
                    this.size = size;
                }

                public Object getPath() {
                    return path;
                }

                public void setPath(Object path) {
                    this.path = path;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }


                public class Small {

                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("hash")
                    @Expose
                    private String hash;
                    @SerializedName("ext")
                    @Expose
                    private String ext;
                    @SerializedName("mime")
                    @Expose
                    private String mime;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;
                    @SerializedName("size")
                    @Expose
                    private Integer size;
                    @SerializedName("path")
                    @Expose
                    private Object path;
                    @SerializedName("url")
                    @Expose
                    private String url;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }

                    public String getExt() {
                        return ext;
                    }

                    public void setExt(String ext) {
                        this.ext = ext;
                    }

                    public String getMime() {
                        return mime;
                    }

                    public void setMime(String mime) {
                        this.mime = mime;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                    public Integer getSize() {
                        return size;
                    }

                    public void setSize(Integer size) {
                        this.size = size;
                    }

                    public Object getPath() {
                        return path;
                    }

                    public void setPath(Object path) {
                        this.path = path;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }


                    public class Thumbnail {

                        @SerializedName("name")
                        @Expose
                        private String name;
                        @SerializedName("hash")
                        @Expose
                        private String hash;
                        @SerializedName("ext")
                        @Expose
                        private String ext;
                        @SerializedName("mime")
                        @Expose
                        private String mime;
                        @SerializedName("width")
                        @Expose
                        private Integer width;
                        @SerializedName("height")
                        @Expose
                        private Integer height;
                        @SerializedName("size")
                        @Expose
                        private Double size;
                        @SerializedName("path")
                        @Expose
                        private Object path;
                        @SerializedName("url")
                        @Expose
                        private String url;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getHash() {
                            return hash;
                        }

                        public void setHash(String hash) {
                            this.hash = hash;
                        }

                        public String getExt() {
                            return ext;
                        }

                        public void setExt(String ext) {
                            this.ext = ext;
                        }

                        public String getMime() {
                            return mime;
                        }

                        public void setMime(String mime) {
                            this.mime = mime;
                        }

                        public Integer getWidth() {
                            return width;
                        }

                        public void setWidth(Integer width) {
                            this.width = width;
                        }

                        public Integer getHeight() {
                            return height;
                        }

                        public void setHeight(Integer height) {
                            this.height = height;
                        }

                        public Double getSize() {
                            return size;
                        }

                        public void setSize(Double size) {
                            this.size = size;
                        }

                        public Object getPath() {
                            return path;
                        }

                        public void setPath(Object path) {
                            this.path = path;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }


                    }
                }
            }
        }
    }
}
